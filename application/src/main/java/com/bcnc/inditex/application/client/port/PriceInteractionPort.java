package com.bcnc.inditex.application.client.port;

import com.bcnc.inditex.domain.client.model.Price;

import java.sql.Timestamp;

public interface PriceInteractionPort {

    Price find(Timestamp date, int brandId, int productId);
}
