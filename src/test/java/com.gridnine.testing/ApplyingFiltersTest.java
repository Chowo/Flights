package com.gridnine.testing;

import com.gridnine.testing.filterEnum.FiltersName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gridnine.testing.Constants.*;
import static com.gridnine.testing.Constants.BACKWARDS_FLIGHT;
import static com.gridnine.testing.filterEnum.FiltersName.*;
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
        List<Flight> result = appFilters.filter(flights, NO_PAST_FLIGHTS, FiltersName.BACKWARDS_FLIGHT, LESS_THAN_TWO_HOURS_GROUNDED);
        assertEquals(List.of(NORMAL_FLIGHT), result);
    }

    @Test
    void filterWithNoWorkingFilters() {
        List<Flight> result = appFilters.filter(flights);
        assertEquals(flights, result);
    }

    @Test
    void filterNoPastFlights() {
        List<Flight> result = appFilters.filter(flights, NO_PAST_FLIGHTS);
        assertEquals(List.of(NORMAL_FLIGHT, BACKWARDS_FLIGHT, LONG_GROUNDED_FLIGHT), result);
    }

    @Test
    void filterBackwardsFlights() {
        List<Flight> result = appFilters.filter(flights,FiltersName.BACKWARDS_FLIGHT);
        assertEquals(List.of(NORMAL_FLIGHT, PAST_FLIGHT, LONG_GROUNDED_FLIGHT), result);
    }

    @Test
    void filterLessThanTwoHoursGrounded() {
        List<Flight> result = appFilters.filter(flights,LESS_THAN_TWO_HOURS_GROUNDED);
        assertEquals(List.of(NORMAL_FLIGHT, PAST_FLIGHT, BACKWARDS_FLIGHT), result);
    }




}