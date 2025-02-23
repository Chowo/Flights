package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NoPastFlights implements FlightsFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(this::isValid).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
