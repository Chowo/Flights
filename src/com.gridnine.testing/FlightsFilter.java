package com.gridnine.testing;

import java.util.List;

public interface FlightsFilter {

    List<Flight> filter(List<Flight> flights);

    boolean isValid(Flight flight);

}
