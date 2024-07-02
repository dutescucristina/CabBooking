package com.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.entity.CalculateRequest;
import com.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.repository.BookingRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RestTemplate restTemplate;
	
	public String addBooking(Booking booking) {
		bookingRepository.save(booking);
		return "Booking created";
	}
	
	public List<Booking> getBookings(){
		List<Booking> result = bookingRepository.findAll();
		return result;
	}

	public Integer calculateFare(CalculateRequest request) {
		Integer result = restTemplate.postForObject("http://CABFAREMICROSERVICE/fare/calculate", request, Integer.class);
		return result;
	}

	public List<Location> getLocations(){
		Location[] result = restTemplate.getForObject("http://CABFAREMICROSERVICE/fare/getLocations", Location[].class);
		return Arrays.asList(result);
	}
}