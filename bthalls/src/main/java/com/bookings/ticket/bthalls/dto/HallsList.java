package com.bookings.ticket.bthalls.dto;

import java.util.List;

import com.bookings.ticket.bthalls.entities.HallDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HallsList {
	private String city;
	List<HallDetails> hallList;

}
