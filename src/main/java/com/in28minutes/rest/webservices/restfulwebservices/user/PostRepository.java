package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //we are extending it with JpaRepository<Post, Integer>
    // : here entity which we are managing is Post and primary id is integer


}
