package bcnc.inditex.infrastructure.client.persistence.mapper;

import com.bcnc.inditex.domain.client.model.Price;
import com.bcnc.inditex.infrastructure.client.persistence.mapper.PriceMapper;
import com.bcnc.inditex.infrastructure.client.persistence.model.PriceEntity;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperTest {

    @Test
    void toDomain_whenHasSingleElement_thenMappingCorrectly() {
        var entity = new PriceEntity(1L, 1, Timestamp.valueOf("2020-05-15 20:00:00"), Timestamp.valueOf("2020-05-15 20:00:00"),1, 35455, 0, 35.87, "EUR");
        var priceDomain = new Price(1L, 1, "2020-05-15 20:00:00", "2020-05-15 20:00:00",1, 35455, 0, 35.87, "EUR");

        var result = PriceMapper.toDomain(entity);

        assertEquals(priceDomain, result);
    }
}