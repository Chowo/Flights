package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> allFlights = FlightBuilder.createFlights();
        System.out.println(allFlights);
        ApplyingFilters filters = new ApplyingFilters();
        System.out.println();
        System.out.println(filters.filter(allFlights, "NoPastFlights"));
        System.out.println(filters.filter(allFlights, "BackwardsFlightsFilter"));
        System.out.println(filters.filter(allFlights, "LessThanTwoHoursGrounded"));
        System.out.println();
        System.out.println(filters.filter(allFlights,"NoPastFlights", "BackwardsFlightsFilter", "LessThanTwoHoursGrounded"));
    }
}
