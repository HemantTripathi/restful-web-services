package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBeanDynamic someBeanDynamic  = new SomeBeanDynamic("value1", "value2", "value3");

		//step-3
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

		//step-2
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

		//step-1
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanDynamic);
		mapping.setFilters(filters);

		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBeanDynamic> list = Arrays.asList(new SomeBeanDynamic("value1", "value2", "value3"),
							 						new SomeBeanDynamic("value10", "value20", "value30"),
							 						new SomeBeanDynamic("value11", "value12", "value13"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
