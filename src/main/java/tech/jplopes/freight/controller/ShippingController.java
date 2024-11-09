package tech.jplopes.freight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.jplopes.freight.controller.dto.ShippingResponse;
import tech.jplopes.freight.service.ShippingService;

@RestController
public class ShippingController {


    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(value = "/shipping/calculate")
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("distance") Double distance,
                                                      @RequestParam("weight") Double weight){
        //Calculate
        var coast = shippingService.calculate(shippingType, distance, weight);

        return ResponseEntity.ok(new ShippingResponse(coast));
    }


}
