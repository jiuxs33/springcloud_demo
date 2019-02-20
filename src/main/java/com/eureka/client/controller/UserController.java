package com.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate server;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return this.server.getForObject("http://localhost:8080/user/"+id, User.class);
	}
}
