package com.bookings.ticket.bthalls.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MoviesHallDetails {
private List<MoviesHallDetailsList> movieHallDetails;
private LocalDate date;

}
