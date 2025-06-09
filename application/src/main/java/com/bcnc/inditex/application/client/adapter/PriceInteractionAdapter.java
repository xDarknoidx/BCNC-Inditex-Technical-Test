package com.bcnc.inditex.application.client.adapter;

import com.bcnc.inditex.application.client.port.PriceInteractionPort;
import com.bcnc.inditex.application.client.port.PricePort;
import com.bcnc.inditex.domain.client.model.Price;
import jakarta.inject.Singleton;

import java.sql.Timestamp;

@Singleton
public class PriceInteractionAdapter implements PriceInteractionPort {

    private final PricePort port;

    public PriceInteractionAdapter(PricePort port) {
        this.port = port;
    }

    @Override
    public Price find(Timestamp date, int brandId, int productId) {
        return port.find(date, brandId, productId);
    }
}
