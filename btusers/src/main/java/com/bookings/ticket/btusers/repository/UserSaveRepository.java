package com.bookings.ticket.btusers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.ticket.btusers.entities.UserCredential;

public interface UserSaveRepository extends JpaRepository<UserCredential, Integer>{

	Optional<UserCredential> findByUsername(String username);

}
