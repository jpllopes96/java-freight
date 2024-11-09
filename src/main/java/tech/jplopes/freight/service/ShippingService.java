package tech.jplopes.freight.service;

import org.springframework.stereotype.Service;
import tech.jplopes.freight.domain.ExpressShippingCalculator;
import tech.jplopes.freight.domain.StandardShippingCalculator;

@Service
public class ShippingService {


    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator, ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(String shippingType,
                            Double distance,
                            Double weight){

        if (shippingType.equalsIgnoreCase("standard")){
            return standardShippingCalculator.calculate(distance,weight);
        }else if(shippingType.equalsIgnoreCase("express")) {
            return expressShippingCalculator.calculate(distance, weight);
        }

        return null;
    }


}
