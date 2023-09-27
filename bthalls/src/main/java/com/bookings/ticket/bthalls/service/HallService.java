package com.bookings.ticket.bthalls.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bookings.ticket.bthalls.dto.BaseOutput;
import com.bookings.ticket.bthalls.dto.HallMovieTime;
import com.bookings.ticket.bthalls.dto.HallsList;
import com.bookings.ticket.bthalls.dto.MoviesHallDetails;
import com.bookings.ticket.bthalls.dto.MoviesHallDetailsList;
import com.bookings.ticket.bthalls.dto.Timings;
import com.bookings.ticket.bthalls.entities.HallDetails;
import com.bookings.ticket.bthalls.entities.MovieDates;
import com.bookings.ticket.bthalls.entities.MovieTimings;
import com.bookings.ticket.bthalls.repository.HallSaveRepository;
import com.bookings.ticket.bthalls.repository.MovieTimeRepository;
import com.bookings.ticket.bthalls.repository.MovieTimingSaveRepository;

@Service
public class HallService {
	@Autowired
	HallSaveRepository hallSaveRepo;

	@Autowired
	MovieTimeRepository movieTimeRepo;

	@Autowired
	MovieTimingSaveRepository movieTimeSaveRepo;

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

	public HallDetails getHallDetails(String id) {
		// TODO Auto-generated method stub
		return hallSaveRepo.findById(Integer.parseInt(id)).get();
	}

	public BaseOutput saveDateTime(HallMovieTime req) {

		Integer hallid = req.getHallId();
		List<MovieDates> timings = req.getDates();
		BaseOutput response = new BaseOutput();

		timings.stream().forEach(obj -> {
			obj.setHallId(hallid);
			List<MovieTimings> timing = obj.getTime();
			MovieDates out1 = new MovieDates();
			out1 = movieTimeRepo.save(obj);

			final Integer movieDateId = out1.getId();

			if (movieDateId != null) {
				timing.stream().forEach(tim -> {
					tim.setMvoieDateId(movieDateId);
					MovieTimings out = new MovieTimings();
					out = movieTimeSaveRepo.save(tim);
				});
			}

		});

		response.setReturnCode(201);
		response.setReturnMsg("Saved");

		return response;
	}

	public MoviesHallDetails getMovieDates(LocalDate date, Long pincode, Integer movieId) {
		List<MovieDates> outList = new ArrayList<>();
		MoviesHallDetails response = new MoviesHallDetails();
		List<MoviesHallDetailsList> movieHallDetailsLists = new ArrayList<>();

		outList = movieTimeRepo.getMovieDates(movieId, date, pincode);
		for (MovieDates temp : outList) {
			MoviesHallDetailsList out2 = new MoviesHallDetailsList();
			out2.setHallId(String.valueOf(temp.getHallId()));

			HallDetails hdOut = new HallDetails();
			hdOut = hallSaveRepo.getHallDetails(temp.getHallId());
			String hallName = hdOut.getName() + ", " + hdOut.getArea();
			out2.setHallName(hallName);
			List<Timings> timings = new ArrayList<>();
			List<MovieTimings> mtOut = new ArrayList<>();
			mtOut = movieTimeSaveRepo.getMovieTimes(temp.getId());

			for (MovieTimings tempTime : mtOut) {
				Timings mtObj = new Timings();
				mtObj.setTiming(tempTime.getTiming());
				timings.add(mtObj);
			}
			out2.setTimings(timings);
			movieHallDetailsLists.add(out2);
		}
		response.setMovieHallDetails(movieHallDetailsLists);
		response.setDate(date);

		return response;
	}

}
