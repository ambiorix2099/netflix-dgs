package com.wayfair.dgs;

import java.math.BigDecimal;

public class Temperature {

  private final BigDecimal kelvin;
  private final BigDecimal celsius;
  private final BigDecimal fahrenheit;

  public Temperature(final double kelvin) {
    this.kelvin = BigDecimal.valueOf(kelvin);
    this.celsius = this.kelvin.subtract(BigDecimal.valueOf(273.15));
    this.fahrenheit = this.kelvin
        .subtract(BigDecimal.valueOf(273.15))
        .multiply(BigDecimal.valueOf(9.0 / 5.0))
        .add(BigDecimal.valueOf(32.0));
  }

  public BigDecimal getKelvin() {
    return kelvin;
  }

  public BigDecimal getCelsius() {
    return celsius;
  }

  public BigDecimal getFahrenheit() {
    return fahrenheit;
  }
}
