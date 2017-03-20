package com.nibado.today.client.openweathermap;

public class OpenWeatherMapClientException extends RuntimeException {
    public OpenWeatherMapClientException(final Exception exception) {
        super(exception);
    }
}
