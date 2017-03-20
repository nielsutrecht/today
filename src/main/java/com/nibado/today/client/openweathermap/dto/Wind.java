package com.nibado.today.client.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Wind {
    private double speed;
    private double gust;
    @JsonProperty("deg")
    private int degrees;
}
