package com.bookings.ticket.btseats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseOutput {
	private String returnMsg;
	private Integer returnCode;

}
