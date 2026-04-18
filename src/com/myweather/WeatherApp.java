/**
 *  Application to show Weather Forecast for requested city.
 */
package com.myweather;

import java.io.IOException;
import java.util.Scanner;

/**
 * WeatherApp class.
 */
public class WeatherApp {

    // JVM entry point.
    public static void main(String[] args) throws IOException {

        // Creating a new Scanner object.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type what city would you like to see a weather forecast?");

        // Creating a string variable with a name of the city.
        String city = scanner.nextLine();

        // Creating an instance of WeatherAPI.
        WeatherAPI api = new WeatherAPI();

        // Creating WeatherResponseParser instance.
        WeatherResponseParser wrr = new WeatherResponseParser();
        wrr.parseAndPrint(api.getForecast(city));

    }
}