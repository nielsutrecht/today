package com.nibado.today.client.openweathermap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibado.today.client.openweathermap.dto.CurrentWeatherDTO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

@Component
@Slf4j
public class OpenWeatherMapClient {
    private static final String CURRENT_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Value("${api.openweathermap}")
    private String openweathermapKey;

    private final OkHttpClient client = new OkHttpClient();

    public CurrentWeatherDTO currentWeather(final String city) {
        String url = String.format(Locale.ROOT, CURRENT_WEATHER_URL, city, openweathermapKey);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();

            log.info("Got {} for {}", response.code(), url);

            return parseCurrentWeather(response.body().byteStream());
        } catch (IOException e) {
            throw new OpenWeatherMapClientException(e);
        }
    }

    static CurrentWeatherDTO parseCurrentWeather(final InputStream json) throws IOException {
        return MAPPER.readValue(json, CurrentWeatherDTO.class);
    }
}
