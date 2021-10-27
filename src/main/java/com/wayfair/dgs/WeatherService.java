package com.wayfair.dgs;

import com.jayway.jsonpath.JsonPath;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@DgsComponent
public class WeatherService {

  private final String apiKey;
  private final WebClient webClient;

  WeatherService(WeatherServiceConfigs configs) {
    this.apiKey = configs.getApiKey();
    this.webClient = WebClient.builder().baseUrl(configs.getUrl()).build();
  }

  @DgsQuery
  public Mono<WeatherResponse> weatherByCity(String city) {
    return webClient.get()
        .uri(weatherRequest(city, apiKey))
        .accept(MediaType.APPLICATION_JSON)
        .acceptCharset(StandardCharsets.UTF_8)
        .retrieve()
        .bodyToMono(String.class)
        .map(json -> new WeatherResponse(JsonPath.<Double>read(json, "$.main.temp")));
  }

  @NotNull
  private static Function<UriBuilder, URI> weatherRequest(String city, String apiKey) {
    return uri -> uri.queryParam("q", city).queryParam("appid", apiKey).build();
  }
}
