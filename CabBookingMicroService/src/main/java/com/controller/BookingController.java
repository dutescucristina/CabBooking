package com.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.entity.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openFirstPage() {
		return "index";
	}

	@RequestMapping(value = "addBooking",method = RequestMethod.POST)
	public String addBooking(HttpServletRequest req, Booking booking, Model model) {
		bookingService.addBooking(booking);
		model.addAttribute("bookings", getBookingsInfo());
		return "viewBookings";
	}
	
	@GetMapping(value = "getBookings")
	public List<Booking> getBookings() {
		return bookingService.getBookings();
	}
	
	@RequestMapping(value = "addBookingView",method = RequestMethod.GET)
	public String addProductPage(Booking booking, Model model) {
		List<Location> locations = bookingService.getLocations();
		model.addAttribute("locations", locations);

		List<Integer> cabTypesResult = Stream.of(CabTypeEnum.values())
				.map(CabTypeEnum::getType)
				.collect(Collectors.toList());

		model.addAttribute("cabTypes",cabTypesResult);

		model.addAttribute("bb", booking);	
		return "addBooking";		
	}

	@RequestMapping(value = "viewBookings",method = RequestMethod.GET)
	public String viewBookings(Model model) {
		model.addAttribute("bookings", getBookingsInfo());
		return "viewBookings";
	}

	@RequestMapping(value = "calculateFareView",method = RequestMethod.GET)
	public String calculateFareView(Model model) {
		List<Location> locations = bookingService.getLocations();

		List<Integer> cabTypesResult = Stream.of(CabTypeEnum.values())
				.map(CabTypeEnum::getType)
				.collect(Collectors.toList());

		model.addAttribute("cabTypes",cabTypesResult);

		model.addAttribute("locations", locations);
		return "calculateFare";
	}

	@RequestMapping(value = "calculateFare",method = RequestMethod.POST)
	public String calculateFare(HttpServletRequest req, Model model) {
		int locationId = Integer.parseInt(req.getParameter("locationId"));
		int cabType = Integer.parseInt(req.getParameter("cabType"));
		int percent = 0;
		//call endpoint to calculate price
		for (CabTypeEnum cte : CabTypeEnum.values()) {
			if (cte.getType() == cabType) {
				percent = cte.getPercent();
				break;
			}
		}
		CalculateRequest request = new CalculateRequest(locationId, percent);

		Integer totalPrice = bookingService.calculateFare(request);
		model.addAttribute("msg", totalPrice);
		List<Location> locations = bookingService.getLocations();

		List<Integer> cabTypesResult = Stream.of(CabTypeEnum.values())
				.map(CabTypeEnum::getType)
				.collect(Collectors.toList());

		model.addAttribute("cabTypes",cabTypesResult);

		model.addAttribute("locations", locations);
		model.addAttribute("lid", locationId);
		model.addAttribute("cti", cabType);
		return "calculateFare";
	}

	private List<BookingInfo> getBookingsInfo(){
		List<Location> locations = bookingService.getLocations();

		Map<Integer,Location> map = new HashMap<>(locations.size());
		for (Location i : locations) map.put(i.getId(),i);

		List<Booking> bookings = bookingService.getBookings();
		List<BookingInfo> bookingResults = new ArrayList<>();
		for(Booking b: bookings){
			Location l = map.get(b.getLocationId());
			//call endpoint to calculate price
			Integer percent = 0;
			for (CabTypeEnum cte : CabTypeEnum.values()) {
				if (cte.getType() == b.getTypeOfCab()) {
					percent = cte.getPercent();
					break;
				}
			}
			CalculateRequest request = new CalculateRequest(b.getLocationId(), percent);

			Integer totalPrice = bookingService.calculateFare(request);
			BookingInfo bi = new BookingInfo(totalPrice , b.getId(), l.getFromLocation(), l.getToLocation(), "Class "+b.getTypeOfCab(), b.getEmail());
			bookingResults.add(bi);
		}
		return bookingResults;
	}
}