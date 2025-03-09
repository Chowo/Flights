package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Constants {
    public static final Segment SEGMENT1 = new Segment(LocalDateTime.of(2030,
            2,
            26,
            11,
            50),
            LocalDateTime.of(2030,
                    2,
                    26,
                    14,
                    0));
    public static final Segment SEGMENT2 = new Segment(LocalDateTime.of(2030,
            2,
            26,
            17,
            25),
            LocalDateTime.of(2030,
                    2,
                    26,
                    20,
                    5));

    public static final Segment PAST_SEGMENT = new Segment(LocalDateTime.of(2025,
            2,
            20,
            20,
            50),
            LocalDateTime.of(2025,
                    2,
                    20,
                    23,
                    20));

    public static final Segment BACKWARDS_SEGMENT = new Segment(LocalDateTime.of(2030,
            2,
            26,
            14,
            50),
            LocalDateTime.of(2030,
                    02,
                    26,
                    10,
                    00));

    public static final Flight NORMAL_FLIGHT = new Flight(List.of(SEGMENT1));
    public static final Flight PAST_FLIGHT = new Flight(List.of(PAST_SEGMENT));
    public static final Flight BACKWARDS_FLIGHT = new Flight(List.of(BACKWARDS_SEGMENT));
    public static final Flight LONG_GROUNDED_FLIGHT = new Flight(List.of(SEGMENT1, SEGMENT2));

}
