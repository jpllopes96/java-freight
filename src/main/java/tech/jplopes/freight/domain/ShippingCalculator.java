package tech.jplopes.freight.domain;

public interface ShippingCalculator {

    Double calculate(Double distance, Double weight);
}
