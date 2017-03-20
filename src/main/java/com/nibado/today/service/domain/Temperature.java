package com.nibado.today.service.domain;

import lombok.Data;

@Data
public class Temperature {
    private final double kelvin;

    public double getCelcius() {
        return kelvin - 273.15;
    }
}
