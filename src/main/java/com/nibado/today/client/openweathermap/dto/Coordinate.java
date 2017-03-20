package com.nibado.today.client.openweathermap.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Coordinate {
    private double lon;
    private double lat;
}
