package com.bcnc.inditex.infrastructure.client.persistence.adapter;

import com.bcnc.inditex.application.client.port.PricePort;
import com.bcnc.inditex.domain.client.model.Price;
import com.bcnc.inditex.infrastructure.client.persistence.PriceJpaRepository;
import com.bcnc.inditex.infrastructure.client.persistence.mapper.PriceMapper;
import com.bcnc.inditex.infrastructure.client.persistence.model.PriceEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@Component
public class PriceJpaAdapter implements PricePort {

    private final PriceJpaRepository repository;

    public PriceJpaAdapter(PriceJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Price find(Timestamp date, int brandId, int productId) {
        List<PriceEntity> entityList = repository.findByBrandIdAndProductIdAndDate(date, brandId, productId);

        if(entityList.size() > 1) {
            entityList = entityList.stream().max(Comparator.comparing(PriceEntity::getPriority)).stream().toList();
        }

        return PriceMapper.toDomain(entityList.stream().findFirst().get());
    }
}
