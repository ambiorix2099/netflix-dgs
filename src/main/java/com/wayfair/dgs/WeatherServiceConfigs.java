package com.wayfair.dgs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("weather")
public class WeatherServiceConfigs {

  private String apiKey;
  private String url;

  public WeatherServiceConfigs() {
  }

  public WeatherServiceConfigs(String apiKey, String url) {
    this.apiKey = apiKey;
    this.url = url;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String apiKey;
    private String url;

    public WeatherServiceConfigs build() {
      return new WeatherServiceConfigs(apiKey, url);
    }

    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }
  }
}
