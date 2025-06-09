package com.bcnc.inditex.infrastructure.client.persistence;

import com.bcnc.inditex.infrastructure.client.persistence.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p from PriceEntity p WHERE p.brandId = ?2 AND p.productId = ?3 AND ?1 between p.startDate AND p.endDate")
    List<PriceEntity> findByBrandIdAndProductIdAndDate(Timestamp date, Integer brandId, Integer ProductId);
}
