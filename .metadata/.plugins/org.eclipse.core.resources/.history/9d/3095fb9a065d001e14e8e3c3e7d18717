package com.bookings.ticket.bthalls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookings.ticket.bthalls.entities.HallDetails;

public interface HallSaveRepository extends JpaRepository<HallDetails, Integer> {

	@Query(value="select * from Hall_details hd where hd.city=?1", nativeQuery = true)
	List<HallDetails> findByCity(String city);

}
