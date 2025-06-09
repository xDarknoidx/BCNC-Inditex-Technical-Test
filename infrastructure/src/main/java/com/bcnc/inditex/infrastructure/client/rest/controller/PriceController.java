package com.bcnc.inditex.infrastructure.client.rest.controller;

import com.bcnc.inditex.application.client.port.PriceInteractionPort;
import com.bcnc.inditex.infrastructure.client.rest.dto.PricesRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    @Autowired
    private final PriceInteractionPort port;

    public PriceController(PriceInteractionPort port) {
        this.port = port;
    }

    @GetMapping("/get-price/{date}/{brandId}/{productId}")
    public PricesRS getPrice(@PathVariable("date") Timestamp date,
                             @PathVariable("brandId") int brandId,
                             @PathVariable("productId") int productId) {
        return PricesRS.toResponse(port.find(date, brandId, productId));
    }
}
