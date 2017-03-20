package com.nibado.today.controller.dto;

import lombok.Data;

@Data
public class WeatherDTO {
    private final String city;
    private final double temperature;
    private final int wind;
}
