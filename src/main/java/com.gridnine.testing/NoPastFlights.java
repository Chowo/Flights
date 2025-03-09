package com.gridnine.testing;

import java.time.LocalDateTime;

public class NoPastFlights extends FlightsFilter {

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
