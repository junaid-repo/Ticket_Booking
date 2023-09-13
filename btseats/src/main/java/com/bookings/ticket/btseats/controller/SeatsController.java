package com.bookings.ticket.btseats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.ticket.btseats.dto.BaseOutput;
import com.bookings.ticket.btseats.dto.SaveSeatsReq;
import com.bookings.ticket.btseats.dto.SeatsDetails;
import com.bookings.ticket.btseats.service.SeatsService;

@RestController
@RequestMapping("/seats")
public class SeatsController {

	@Autowired
	SeatsService serv;

	@PostMapping("/addSeats")
	ResponseEntity<BaseOutput> addSeats(@RequestBody SaveSeatsReq req) {

		BaseOutput response = new BaseOutput();

		response = serv.saveSeats(req);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/get/seatDetails/{hallId}")
	ResponseEntity<SeatsDetails> getSeatsDetails(@PathVariable String hallId){
		
		SeatsDetails response = new SeatsDetails();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

		
	}
	
	

}
