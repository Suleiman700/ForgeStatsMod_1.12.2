package com.example.examplemod.Functions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Time {
    private static int year = 0;
    private static int month = 0;
    private static int day = 0;
    private static int hour = 0;
    private static int minute = 0;
    private static int second = 0;
    private static int millis = 0;


    // Update date and time
    private static void updateDateTime() {
        LocalDateTime now = LocalDateTime.now();
        year = now.getYear();
        month = now.getMonthValue();
        day = now.getDayOfMonth();
        hour = now.getHour();
        minute = now.getMinute();
        second = now.getSecond();
        millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available.
    }

    // Get date and time
    public static String getDateTime() {
        updateDateTime();
        String string = String.format("[%d-%02d-%02d %02d:%02d:%02d]", day, month, year, hour, minute, second);
        return string;
    }
}
