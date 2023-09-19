package com.bookings.ticket.btusers.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseOutput {
	private String returnMsg;
	private Integer returnCode;
	private String username;

}