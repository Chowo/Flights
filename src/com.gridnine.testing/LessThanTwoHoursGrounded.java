package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class LessThanTwoHoursGrounded extends FlightsFilter {

    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() == 1) {
            return true;
        }
        long groundedTime = 0L;
        for (int i = 0; i < segments.size() - 1; i++) {

            groundedTime = +ChronoUnit.HOURS.between(segments.get(0).getArrivalDate(), segments.get(1).getDepartureDate());
        }
        if (groundedTime > 2) {
            return false;
        } else {
            return true;
        }
    }
}
