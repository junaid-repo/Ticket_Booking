package com.bookings.ticket.bthalls.dto;

import java.util.List;

import com.bookings.ticket.bthalls.entities.MovieDates;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HallMovieTime {
	private Integer hallId;
	List<MovieDates> dates;

}
