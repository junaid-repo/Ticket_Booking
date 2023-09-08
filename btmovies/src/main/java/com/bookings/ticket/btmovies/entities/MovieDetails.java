package com.bookings.ticket.btmovies.entities;

import java.time.LocalDate;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class MovieDetails {
	String name = "";
	String languages = "";
	String genere = "";
	Double lengthInMinutes = null;
	LocalDate releaseDate;
	Float ratings;
	String casts;

}
