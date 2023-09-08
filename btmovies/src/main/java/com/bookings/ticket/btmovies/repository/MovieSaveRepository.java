package com.bookings.ticket.btmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.ticket.btmovies.entities.MovieDetails;

public interface MovieSaveRepository extends JpaRepository<MovieDetails, Integer> {

}
