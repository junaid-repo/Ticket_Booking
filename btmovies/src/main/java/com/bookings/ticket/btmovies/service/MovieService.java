package com.bookings.ticket.btmovies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bookings.ticket.btmovies.dto.BaseOutput;
import com.bookings.ticket.btmovies.dto.MovieHallsList;
import com.bookings.ticket.btmovies.entities.MovieDetails;
import com.bookings.ticket.btmovies.repository.MovieSaveRepository;
import com.bookings.ticket.btmovies.repository.MovieWithHallSaveRepository;

@Service
public class MovieService {
	@Autowired
	MovieSaveRepository movieSaveRepo;

	@Autowired
	MovieWithHallSaveRepository hallMovieRepo;

	public BaseOutput addMovies(MovieDetails req) {
		BaseOutput response = new BaseOutput();
		MovieDetails out = new MovieDetails();
		out = movieSaveRepo.save(req);

		response.setReturnCode(HttpStatus.CREATED.value());
		response.setReturnMsg(HttpStatus.CREATED.toString());
		return response;
	}

	public BaseOutput saveMovieWithHall(MovieHallsList req) {
		BaseOutput resp= new BaseOutput();
		resp=(BaseOutput) req.getMovieList().stream().map(obj -> {
			BaseOutput response = new BaseOutput();

			hallMovieRepo.save(obj);
			response.setReturnCode(HttpStatus.CREATED.value());
			response.setReturnMsg(HttpStatus.CREATED.toString());

			return response;

		});
		

		return resp;
	}

}
