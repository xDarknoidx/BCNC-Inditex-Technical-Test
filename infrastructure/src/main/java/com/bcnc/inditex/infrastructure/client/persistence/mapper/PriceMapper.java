package com.bcnc.inditex.infrastructure.client.persistence.mapper;

import com.bcnc.inditex.domain.client.model.Price;
import com.bcnc.inditex.infrastructure.client.persistence.model.PriceEntity;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class PriceMapper {

    public static Price toDomain(PriceEntity entity) {
        return new Price(entity.getId(),
                entity.getBrandId(),
                entity.getStartDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                entity.getEndDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurr());
    }
}
