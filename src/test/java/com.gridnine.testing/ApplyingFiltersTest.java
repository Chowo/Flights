package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gridnine.testing.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplyingFiltersTest {

    private ApplyingFilters appFilters;
    private List<Flight> flights;



    @BeforeEach
    void init() {
        appFilters = new ApplyingFilters();
        flights = new ArrayList<>();
        flights.add(NORMAL_FLIGHT);
        flights.add(PAST_FLIGHT);
        flights.add(BACKWARDS_FLIGHT);
        flights.add(LONG_GROUNDED_FLIGHT);
    }

    @Test
    void filterNormalWork() {
        List<Flight> result = appFilters.filter(flights, "NoPastFlights", "BackwardsFlightsFilter", "LessThanTwoHoursGrounded");
        assertEquals(List.of(NORMAL_FLIGHT), result);
    }

    @Test
    void filterWithNoWorkingFilters() {
        List<Flight> result = appFilters.filter(flights, "");
        assertEquals(flights, result);
    }

}