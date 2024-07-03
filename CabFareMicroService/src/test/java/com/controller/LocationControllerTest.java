package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.entity.CalculateRequest;
import com.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)		// it help to create mock or fake object.
@SpringBootTest
class LocationControllerTest {


    @Mock
    LocationService locationService;		// mock for service layer

    @InjectMocks
    LocationController locationController;		// inject that mock in dao layer

    @Test
    void testCalculate() {
        CalculateRequest cr = new CalculateRequest();

        cr.setLocationId(1);
        cr.setPercent(10);
        // fake result
        Mockito.when(locationService.calculateFare(cr)).thenReturn(220);		// fake information ready

        // testing
        Integer result = locationController.calculateFare(cr);
        assertEquals(220, result);

    }

}