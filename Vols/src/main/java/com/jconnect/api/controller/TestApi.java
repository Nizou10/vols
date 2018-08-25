package com.jconnect.api.controller;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestApi {
	
	@PostMapping(value="/coin",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Coin> add(@RequestBody Coin coin) {
		
		System.out.println("adding :"  + coin.getName());
		System.out.println("adding :"  + coin.getPrice());
		return new ResponseEntity<Coin>(coin, HttpStatus.CREATED);
	}

}

class Coin implements Serializable{

	private static final long serialVersionUID = 2092096915229115757L;
	private String name;
	private String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}