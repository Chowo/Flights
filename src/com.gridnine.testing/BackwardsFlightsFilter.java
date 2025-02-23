package com.gridnine.testing;

public class BackwardsFlightsFilter extends FlightsFilter {

    @Override
    public boolean isValid(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                return false;
            }
        }
        return true;
    }
}
