package com.bookings.ticket.bthalls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookings.ticket.bthalls.entities.MovieTimings;

public interface MovieTimingSaveRepository extends JpaRepository<MovieTimings, Integer>{
	
	@Query(value="select * from movie_date_times mdt where mdt.mvoie_date_id=?1", nativeQuery=true)
	List<MovieTimings> getMovieTimes(Integer id);

}
