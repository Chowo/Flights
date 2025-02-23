package com.gridnine.testing;

import java.util.*;

public class ApplyingFilters {

    private Map<String, FlightsFilter> filters;

    public ApplyingFilters() {
        Map<String, FlightsFilter> filters = new HashMap<>();
        FlightsFilter filter1 = new NoPastFlights();
        FlightsFilter filter2 = new BackwardsFlightsFilter();
        FlightsFilter filter3 = new LessThanTwoHoursGrounded();
        filters.put("NoPastFlights", filter1);
        filters.put("BackwardsFlightsFilter", filter2);
        filters.put("LessThanTwoHoursGrounded", filter3);
        this.filters = filters;
    }

    private List<FlightsFilter> getEnabledFilters(String... filtersNames) {
        List<FlightsFilter> enabledFilters = new ArrayList<>();

        for (String filter : filtersNames) {
            if (filters.containsKey(filter)) {
                FlightsFilter tmp = filters.get(filter);
                tmp.enable();
                enabledFilters.add(tmp);
            }
        }
        return enabledFilters;
    }

    public List<Flight> filter(List<Flight> flights, String... filtersNames) {
        List<FlightsFilter> enabledFilters = getEnabledFilters(filtersNames);
        List<Flight> result = flights;
        for (FlightsFilter filter : enabledFilters) {
            result = filter.filter(result);
        }
        return result;
    }

}
