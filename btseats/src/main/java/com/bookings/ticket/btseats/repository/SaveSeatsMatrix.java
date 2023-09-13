package com.bookings.ticket.btseats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.ticket.btseats.entities.SeatsMatrix;

public interface SaveSeatsMatrix extends JpaRepository<SeatsMatrix, Integer>{

}
