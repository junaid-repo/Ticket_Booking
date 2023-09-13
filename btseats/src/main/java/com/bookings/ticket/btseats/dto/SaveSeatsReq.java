package com.bookings.ticket.btseats.dto;

import java.util.List;

import com.bookings.ticket.btseats.entities.SeatsArrangements;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaveSeatsReq {
	List<SeatsArrangements> seatsDetails;
	Integer hallId;
	String time;

}
