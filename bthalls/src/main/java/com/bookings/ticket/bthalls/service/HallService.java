package com.bookings.ticket.bthalls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bookings.ticket.bthalls.dto.BaseOutput;
import com.bookings.ticket.bthalls.dto.HallsList;
import com.bookings.ticket.bthalls.entities.HallDetails;
import com.bookings.ticket.bthalls.repository.HallSaveRepository;

@Service
public class HallService {
	@Autowired
	HallSaveRepository hallSaveRepo;

	public BaseOutput saveHallDetails(HallDetails req) {
		BaseOutput response = new BaseOutput();
		hallSaveRepo.save(req);

		response.setReturnCode(HttpStatus.CREATED.value());
		response.setReturnMsg(HttpStatus.CREATED.toString());
		return response;
	}

	public HallsList getHallsListByCity(String city) {

		HallsList response = new HallsList();
		List<HallDetails> hallsList = new ArrayList<>();

		hallsList = hallSaveRepo.findByCity(city);
		response.setCity(city);
		response.setHallList(hallsList);

		return response;
	}

}
