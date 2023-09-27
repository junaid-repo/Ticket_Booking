package com.bookings.ticket.bthalls.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookings.ticket.bthalls.entities.MovieDates;

public interface MovieTimeRepository extends JpaRepository<MovieDates, Integer>{
	
	@Query(value="select md.* from movie_dates md, hall_details hd where md.movie_id=?1 and md.date=?2 and hd.id=md.hall_id and hd.pincode=?3", nativeQuery=true)
	List<MovieDates> getMovieDates(Integer movieId, LocalDate date, Long pincode);

}
