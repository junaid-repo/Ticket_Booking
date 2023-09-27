package com.bookings.ticket.btmovies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.ticket.btmovies.dto.BaseOutput;
import com.bookings.ticket.btmovies.dto.MovieHallsList;
import com.bookings.ticket.btmovies.entities.MovieDetails;
import com.bookings.ticket.btmovies.service.MovieService;

@RestController
@RequestMapping("/bt/shows")
public class MoviesContoller {

	@Autowired
	MovieService serv;

	@PostMapping("/add/movies")
	ResponseEntity<BaseOutput> addMovies(@RequestBody MovieDetails req) {
		BaseOutput response = new BaseOutput();

		response = serv.addMovies(req);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PostMapping("/link/halls")
	ResponseEntity<BaseOutput> linkHalls(@RequestBody MovieHallsList req) {
		BaseOutput response = new BaseOutput();

		response = serv.saveMovieWithHall(req);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


}
