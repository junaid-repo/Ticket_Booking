package com.bookings.ticket.btseats.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookings.ticket.btseats.dto.BaseOutput;
import com.bookings.ticket.btseats.dto.SaveSeatsReq;
import com.bookings.ticket.btseats.entities.SeatsArrangements;
import com.bookings.ticket.btseats.entities.SeatsMatrix;
import com.bookings.ticket.btseats.repository.SaveSeatsMatrix;
import com.bookings.ticket.btseats.repository.SaveSeatsRepository;

@Service
public class SeatsService {

	@Autowired
	SaveSeatsRepository seatsRepo;

	@Autowired
	SaveSeatsMatrix seatMRepo;

	public BaseOutput saveSeats(SaveSeatsReq req) {
		BaseOutput response = new BaseOutput();
		
		req.getSeatsDetails().stream().forEach(obj -> {
			SeatsArrangements sa = new SeatsArrangements();

			sa.setLength(obj.getLength());
			sa.setBreadth(obj.getBreadth());
			sa.setHallId(obj.getHallId());
			sa.setPack(obj.getPack());
			sa.setPrice(obj.getPrice());
			sa.setHallId(req.getHallId());
			seatsRepo.save(sa);

			Integer length = Integer.parseInt(obj.getLength());
			Integer breadth = Integer.parseInt(obj.getBreadth());
			
			LocalDateTime date = LocalDateTime.now();
			
			for (int j = 1; j <=breadth; j++) {
				SeatsMatrix sm = new SeatsMatrix();
				sm.setTime(req.getTime());
				sm.setHallId(req.getHallId());
				sm.setA(String.valueOf(j) + "##V");
				sm.setB(String.valueOf(j) + "##V");
				sm.setC(String.valueOf(j) + "##V");
				sm.setD(String.valueOf(j) + "##V");
				sm.setE(String.valueOf(j) + "##V");
				sm.setF(String.valueOf(j) + "##V");
				sm.setG(String.valueOf(j) + "##V");
				sm.setH(String.valueOf(j) + "##V");
				sm.setI(String.valueOf(j) + "##V");
				sm.setJ(String.valueOf(j) + "##V");
				sm.setK(String.valueOf(j) + "##V");
				sm.setL(String.valueOf(j) + "##V");
				sm.setM(String.valueOf(j) + "##V");
				sm.setN(String.valueOf(j) + "##V");
				
				seatMRepo.save(sm);

			}

		});

		response.setReturnCode(201);
		response.setReturnMsg("Updated");
		return response;

	}

}
