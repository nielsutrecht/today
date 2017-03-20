package com.nibado.today.controller;

import com.nibado.today.service.WeatherService;
import com.nibado.today.service.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Weather get() {
        return weatherService.getHomeWeather();
    }
}
