package com.bookings.ticket.btseats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.ticket.btseats.entities.SeatsArrangements;

public interface SaveSeatsRepository extends JpaRepository<SeatsArrangements, Integer>{

}
