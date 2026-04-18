package com.myweather;

import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WeatherResponseParser class.
 */
public class WeatherResponseParser {

    public void parseAndPrint(String jsonResponce) {
        JSONObject jsonObject = new JSONObject(jsonResponce);

        if (jsonObject.getInt("cod") == 200) {
            System.out.println("Weather forecast for city: ");
            JSONArray forecasts = jsonObject.getJSONArray("list");
            for (int i = 0; i < forecasts.length(); i++) {

                // Getting an object from an array of data.
                JSONObject forecast = forecasts.getJSONObject(i);

                // Getting timestamp variable.
                long timestamp = forecast.getLong("dt");

                // Creating date type variable initializing it.
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp * 1000));

                // Creating double type variable of temperature initializing it.
                double temperature = forecast.getJSONObject("main").getDouble("temp");

                // Creating double type variable of humidity initializing it.
                int humidity = forecast.getJSONObject("main").getInt("humidity");

                // Creating a string variable with description.
                String description = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

                // Printing getting data to console.
                System.out.println("Date: " + date + ", temperature: " + temperature + " °C, humidity: " + humidity + ", " + description);
            }

        } else {
            System.out.println("Request contains not accessible city / town data.");
        }
    }
}
