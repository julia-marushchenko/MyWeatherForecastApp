package com.myweather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherAPI {

    // Constants to store data for weather source.
    private static final String API_KEY = "ftzftgv"; // Secret Key
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    // Method to request a weather data from http://api.openweathermap.org
    public String getForecast(String city) throws IOException {
        String apiUrl = BASE_URL + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8) + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder responce = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            responce.append(line);
        }
        reader.close();

        return responce.toString();

    }

}
