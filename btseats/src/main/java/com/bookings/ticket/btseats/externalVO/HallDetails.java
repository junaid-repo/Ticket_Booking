package com.bookings.ticket.btseats.externalVO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class HallDetails {
	private String name = null;
	private String area = null;
	private Long pincode = null;
	private String city = null;
	private String state = null;
	private String ticketCancellation = null;
	private String parkingFacility = null;
	private String foodCourt = null;

	private Integer id;

}
