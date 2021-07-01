package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RestApi {

	@Autowired
	private UserService service;
	
	@GetMapping("{name}")
	public String greetings(@PathVariable String name) {
		return "Hello "+name;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public User storeApi(@RequestBody User user) {
		return service.store(user);
	}
	
	@GetMapping("user/{id}")
	public User findApi(@PathVariable int id) {
		return service.findUser(id);
	}
}
