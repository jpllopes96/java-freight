package tech.jplopes.freight.service;

import org.springframework.stereotype.Service;
import tech.jplopes.freight.domain.StandardShippingCalculator;

@Service
public class ShippingService {


    private final StandardShippingCalculator standardShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
    }

    public Double calculate(String shippingType,
                            Double distance,
                            Double weight){

        if (shippingType.equalsIgnoreCase("standard")){
            return standardShippingCalculator.calculate(distance,weight);
        }

        return 0.0;
    }


}
