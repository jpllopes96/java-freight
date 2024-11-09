package tech.jplopes.freight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.jplopes.freight.controller.dto.ShippingResponse;

@RestController
public class ShippingController {

    @GetMapping(value = "/shipping/calculate")
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("distance") Double distance,
                                                      @RequestParam("weight") Double weight){
        //Calculate

        return ResponseEntity.ok(new ShippingResponse(0.0));
    }


}
