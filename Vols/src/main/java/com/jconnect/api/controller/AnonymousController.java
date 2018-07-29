package com.jconnect.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnonymousController {
	
	
	@GetMapping("/home")
	public String anonymousHome() {
		
		return "this for anonymous users";
	}

}
