package com.bookings.ticket.btmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.ticket.btmovies.entities.MovieWidHalls;

public interface MovieWithHallSaveRepository extends JpaRepository<MovieWidHalls, Integer> {

}
