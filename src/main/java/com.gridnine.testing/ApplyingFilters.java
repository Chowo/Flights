package com.gridnine.testing;

import com.gridnine.testing.filterEnum.FiltersName;

import java.util.*;

import static com.gridnine.testing.filterEnum.FiltersName.*;

public class ApplyingFilters {

    private Map<FiltersName, FlightsFilter> filters;

    public ApplyingFilters() {
        Map<FiltersName, FlightsFilter> filters = new HashMap<>();
        FlightsFilter filter1 = new NoPastFlights();
        FlightsFilter filter2 = new BackwardsFlightsFilter();
        FlightsFilter filter3 = new LessThanTwoHoursGrounded();
        filters.put(NO_PAST_FLIGHTS, filter1);
        filters.put(BACKWARDS_FLIGHT, filter2);
        filters.put(LESS_THAN_TWO_HOURS_GROUNDED, filter3);
        this.filters = filters;
    }

    private List<FlightsFilter> getEnabledFilters(FiltersName... filtersNames) {
        List<FlightsFilter> enabledFilters = new ArrayList<>();

        for (FiltersName filter : filtersNames) {
            if (filters.containsKey(filter)) {
                FlightsFilter tmp = filters.get(filter);
                tmp.enable();
                enabledFilters.add(tmp);
            }
        }
        System.out.println(enabledFilters);
        return enabledFilters;
    }

    public List<Flight> filter(List<Flight> flights, FiltersName... filtersNames) {
        List<FlightsFilter> enabledFilters = getEnabledFilters(filtersNames);
        if (enabledFilters.isEmpty()) {
            return flights;
        }
        List<Flight> result = flights;
        for (FlightsFilter filter : enabledFilters) {
            result = filter.filter(result);
        }
        return result;
    }

}
