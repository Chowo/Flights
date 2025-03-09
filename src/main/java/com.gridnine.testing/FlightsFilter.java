package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public abstract class FlightsFilter {

    private boolean enabled = false;

    List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(this::isValid).collect(Collectors.toList());
    }

    abstract boolean isValid(Flight flight);

    void enable() {
        enabled = true;
    }

    void disable() {
        enabled = false;
    }

    boolean isEnabled() {
        return enabled;
    }


}
