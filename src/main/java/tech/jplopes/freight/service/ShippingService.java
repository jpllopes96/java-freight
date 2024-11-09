package tech.jplopes.freight.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.jplopes.freight.domain.ExpressShippingCalculator;
import tech.jplopes.freight.domain.ShippingCalculator;
import tech.jplopes.freight.domain.StandardShippingCalculator;

@Service
public class ShippingService {


    private final ShippingCalculator standardCalculator;
    private final ShippingCalculator expressCalculator;


    public ShippingService(@Qualifier("standardShippingCalculator") ShippingCalculator standardCalculator, @Qualifier("expressShippingCalculator") ShippingCalculator expressCalculator) {
        this.standardCalculator = standardCalculator;
        this.expressCalculator = expressCalculator;
    }

    public Double calculate(String shippingType,
                            Double distance,
                            Double weight){

        if (shippingType.equalsIgnoreCase("standard")){
            return standardCalculator.calculate(distance,weight);
        }else if(shippingType.equalsIgnoreCase("express")) {
            return expressCalculator.calculate(distance, weight);
        }

        return null;
    }


}
