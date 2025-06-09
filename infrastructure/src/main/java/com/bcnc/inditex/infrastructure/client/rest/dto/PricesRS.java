package com.bcnc.inditex.infrastructure.client.rest.dto;

import com.bcnc.inditex.domain.client.model.Price;

public record PricesRS(int productId, int brandId, int priority, String startDate, String endDate, String price) {
    public static PricesRS toResponse(Price price) {
        return new PricesRS(price.productId(), price.brandId(), price.priority(), price.startDate(), price.endDate(), price.price() + " " + price.curr());
    }
}
