package com.controller;

import com.entity.CalculateRequest;
import com.entity.Location;
import com.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fare")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping(value = "calculate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer createAccount(@RequestBody CalculateRequest calculateRequest) {
        return locationService.calculateFare(calculateRequest);
    }

    @GetMapping(value = "getLocations")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }
}
