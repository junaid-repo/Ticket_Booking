package com.bookings.ticket.btusers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookings.ticket.btusers.dto.BaseOutput;
import com.bookings.ticket.btusers.entities.UserCredential;
import com.bookings.ticket.btusers.repository.UserSaveRepository;

@Service
public class UserService {

	@Autowired
	UserSaveRepository userRegRepo;

	@Autowired
	PasswordEncoder psdEnocder;

	@Autowired
	JwtService jwtService;

	public BaseOutput registerUser(UserCredential user) {
		user.setPassword(psdEnocder.encode(user.getPassword()));
		UserCredential out = new UserCredential();
		BaseOutput response = new BaseOutput();
		String username = "";

		out = userRegRepo.save(user);

		if (out.getId() > 0) {
			username = user.getName().replaceAll("\\s", "").toLowerCase() + String.valueOf(out.getId());
		}

		out.setUsername(username);

		out = userRegRepo.save(out);

		response.setReturnCode(201);
		response.setReturnMsg("User Created");
		response.setUsername(username);
		// TODO Auto-generated method stub
		return response;
	}

	public String generateToken(String username) {
		// TODO Auto-generated method stub
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);

	}

}
