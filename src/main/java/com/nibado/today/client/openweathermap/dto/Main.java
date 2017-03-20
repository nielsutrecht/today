package com.nibado.today.client.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Main {
    @JsonProperty("temp")
    private double temperature;
    @JsonProperty("temp_min")
    private double temperatureMin;
    @JsonProperty("temp_max")
    private double temperatureMax;
    private int pressure;
    private int humidity;
}
