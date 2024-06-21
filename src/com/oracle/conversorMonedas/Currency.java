package com.oracle.conversorMonedas;

import java.util.Map;

public record Currency(Map<String,Double> conversion_rates) {
    public Double getConversionRate(String monedaObjetivo) {
        return conversion_rates.get(monedaObjetivo);
    }
}
