package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LessThanTwoHoursGrounded implements FlightsFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(this::isValid).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() == 1) {
            return true;
        }
        long groundedTime = 0L;
        for (int i = 0; i < segments.size()-1; i++) {

            groundedTime=+ChronoUnit.HOURS.between(segments.get(1).getDepartureDate(), segments.get(0).getArrivalDate());

        }
        if (groundedTime > 2) {
            return false;
        } else {
            return true;
        }
    }
}
