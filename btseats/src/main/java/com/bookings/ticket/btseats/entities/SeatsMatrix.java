package com.bookings.ticket.btseats.entities;

import java.time.LocalDateTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SeatsMatrix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	Integer hallId;
	String time;
	String a;
	String b;
	String c;
	String d;
	String e;
	String f;
	String g;
	String h;
	String i;
	String j;
	String k;
	String l;
	String m;
	String n;

}
