package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+ id);

		return user;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	//
	// input - details of user
	// output - CREATED & Return the created URI
	
	//HATEOAS
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

	/* If we want to return the posts done by any user
	* we can implement like this
	* */
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<User> optionalUser =  userRepository.findById(id);
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("id-"+ id);
		return  optionalUser.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post posts) {
		Optional<User> optionalUser =  userRepository.findById(id);
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("id-"+ id);

		User user  = optionalUser.get();
		posts.setUser(user);
		postRepository.save(posts);

		// CREATED
		// /user/{id}     savedUser.getId()

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(posts.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
