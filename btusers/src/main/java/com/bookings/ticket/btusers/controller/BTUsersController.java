package com.bookings.ticket.btusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.ticket.btusers.dto.AuthRequest;
import com.bookings.ticket.btusers.dto.BaseOutput;
import com.bookings.ticket.btusers.entities.UserCredential;
import com.bookings.ticket.btusers.service.UserService;

@RestController
@RequestMapping("/bt/users")
public class BTUsersController {

	@Autowired
	UserService serv;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/auth/register")
	ResponseEntity<BaseOutput> regsiterUser(@RequestBody UserCredential req) {

		BaseOutput response = new BaseOutput();
		response = serv.registerUser(req);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/auth/generateToken")
	ResponseEntity<String> generateToken(@RequestBody AuthRequest au) {
		String response = "";
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(au.getUsername(), au.getPassword()));
		if (authenticate.isAuthenticated()) {
			response = serv.generateToken(au.getUsername());
		} else {
			throw new RuntimeException("Invalid access");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/auth/validateToken/{token}")
	ResponseEntity<String> validateToken(@PathVariable String token) {
		serv.validateToken(token);
		return ResponseEntity.status(HttpStatus.FOUND).body("Token is valid");
	}

}
