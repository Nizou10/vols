package com.jconnect.api.controller;

import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jconnect.api.dto.UserDTO;
import com.jconnect.entities.Authority;
import com.jconnect.entities.User;
import com.jconnect.enums.Authorities;
import com.jconnect.service.UserService;

@RestController
public class RegisterController {

    
    @Resource(name = "userService")
    protected UserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto){
		
		PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Authority authority = new Authority();
        authority.setName(Authorities.ROLE_USER.name());
        HashSet<Authority> authorities = new HashSet<Authority>();
        authorities.add(authority);
        user.setAuthorities(authorities);
        userService.addUser(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	

}
