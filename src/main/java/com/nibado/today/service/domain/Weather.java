package com.nibado.today.service.domain;

import lombok.Data;

@Data
public class Weather {
    private final String city;
    private final Temperature temperature;
    private final Wind wind;
}

