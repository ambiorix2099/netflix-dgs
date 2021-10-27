package com.wayfair.dgs;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class WeatherServiceTest {

  private static WeatherService WEATHER_SERVICE;

  @BeforeAll
  static void beforeAll() {
    final WeatherServiceConfigs configs = WeatherServiceConfigs.newBuilder()
        .setApiKey("9bea787a7b8abfdec5cdf1bd2f444f51")
        .setUrl("api.openweathermap.org/data/2.5/weather")
        .build();

    WEATHER_SERVICE = new WeatherService(configs);
  }

  @Test
  void getWeather() {
    StepVerifier
        .create(WEATHER_SERVICE.weatherByCity("new york"))
        .expectNextMatches(r -> r.getTemperature().getCelsius().compareTo(BigDecimal.ZERO) > 0)
        .verifyComplete();
  }
}
