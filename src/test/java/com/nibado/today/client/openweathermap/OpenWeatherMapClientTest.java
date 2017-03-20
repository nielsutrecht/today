package com.nibado.today.client.openweathermap;

import com.nibado.today.client.openweathermap.dto.CurrentWeatherDTO;
import org.junit.Test;

import java.io.InputStream;

public class OpenWeatherMapClientTest {
    @Test
    public void parseCurrentWeather() throws Exception {
        CurrentWeatherDTO currentWeather = OpenWeatherMapClient.parseCurrentWeather(resource("/weather/current.json"));

        System.out.println(currentWeather);
    }

    private static InputStream resource(String name) {
        return OpenWeatherMapClientTest.class.getResourceAsStream(name);
    }
}
