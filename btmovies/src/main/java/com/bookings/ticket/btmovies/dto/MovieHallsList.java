package com.bookings.ticket.btmovies.dto;

import java.util.List;

import com.bookings.ticket.btmovies.entities.MovieWidHalls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieHallsList {
	List<MovieWidHalls> movieList;

}
