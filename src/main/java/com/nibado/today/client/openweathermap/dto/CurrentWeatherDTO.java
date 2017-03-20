package com.nibado.today.client.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDTO {
    @JsonProperty("coord")
    private Coordinate coordinate;
    private Main main;
    private Wind wind;
    private String name;
}
