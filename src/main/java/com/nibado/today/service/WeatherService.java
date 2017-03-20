package com.nibado.today.service;

import com.nibado.today.client.openweathermap.OpenWeatherMapClient;
import com.nibado.today.client.openweathermap.dto.CurrentWeatherDTO;
import com.nibado.today.service.domain.Temperature;
import com.nibado.today.service.domain.Weather;
import com.nibado.today.service.domain.Wind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Value("${address.home.city}")
    private String homeCity;

    private final OpenWeatherMapClient openWeatherMapClient;

    @Autowired
    public WeatherService(final OpenWeatherMapClient openWeatherMapClient) {
        this.openWeatherMapClient = openWeatherMapClient;
    }

    public Weather getWeather(final String city) {
        CurrentWeatherDTO currentWeather = openWeatherMapClient.currentWeather(city);

        return new Weather(
                currentWeather.getName(),
                new Temperature(currentWeather.getMain().getTemperature()),
                new Wind(currentWeather.getWind().getDegrees(), currentWeather.getWind().getSpeed()));
    }

    public Weather getHomeWeather() {
        return getWeather(homeCity);
    }
}
