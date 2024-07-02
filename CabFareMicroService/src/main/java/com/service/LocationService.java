package com.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.entity.CalculateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Location;
import com.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getLocations(){
        List<Location> result = locationRepository.findAll();
        return result;
    }

    public Integer calculateFare(CalculateRequest request){
        Optional<Location> location = locationRepository.findById(request.getLocationId());
        if(location.isPresent()) {
            Location l = location.get();
            BigDecimal percent = BigDecimal.valueOf(l.getPrice()).multiply(BigDecimal.valueOf(request.getPercent()).divide(BigDecimal.valueOf(100)));
            return (BigDecimal.valueOf(l.getPrice()).add(percent)).intValue();
        }
        return 0;
    }
}