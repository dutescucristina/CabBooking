package com.service;

import static org.junit.jupiter.api.Assertions.*;

import com.entity.CalculateRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest						// spring boot testing annotation
class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @Test
    void testCalculateFare() {
        CalculateRequest cr = new CalculateRequest();

        cr.setLocationId(1);
        cr.setPercent(10);
        Integer result = locationService.calculateFare(cr);
        assertEquals(220, result);
    }

}