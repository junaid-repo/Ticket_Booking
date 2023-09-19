package com.bookings.ticket.btusers.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bookings.ticket.btusers.entities.UserCredential;
import com.bookings.ticket.btusers.repository.UserSaveRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserSaveRepository userRegRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Optional<UserCredential> creds = userRegRepo.findByUsername(username);
		return creds.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));

	}

}
