package com.gridnine.testing;

import com.gridnine.testing.filterEnum.FiltersName;

import java.util.List;

import static com.gridnine.testing.filterEnum.FiltersName.*;

public class Main {
    public static void main(String[] args) {
        List<Flight> allFlights = FlightBuilder.createFlights();
        System.out.println(allFlights);
        ApplyingFilters filters = new ApplyingFilters();
        System.out.println();
        System.out.println(filters.filter(allFlights, NO_PAST_FLIGHTS));
        System.out.println(filters.filter(allFlights, BACKWARDS_FLIGHT));
        System.out.println(filters.filter(allFlights, LESS_THAN_TWO_HOURS_GROUNDED));
        System.out.println();
        System.out.println(filters.filter(allFlights,NO_PAST_FLIGHTS, BACKWARDS_FLIGHT, LESS_THAN_TWO_HOURS_GROUNDED));
    }
}
