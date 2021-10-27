package com.wayfair.dgs;

public class WeatherResponse {

  private final Temperature temperature;

  public WeatherResponse(final double temperatureInKelvin) {
    this.temperature = new Temperature(temperatureInKelvin);
  }

  public Temperature getTemperature() {
    return temperature;
  }
}
