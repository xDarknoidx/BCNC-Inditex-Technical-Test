package bcnc.inditex.infrastructure.client.rest.dto;

import com.bcnc.inditex.domain.client.model.Price;
import com.bcnc.inditex.infrastructure.client.rest.dto.PricesRS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricesRSTest {

    @Test
    void toResponse_whenHasSingleElement_thenMappingCorrectly() {
        var priceDomain = new Price(1L, 1, "2020-05-15 20:00:00", "2020-05-15 20:00:00",1, 35455, 0, 35.87, "EUR");
        var pricesRS = new PricesRS(35455, 1, 0, "2020-05-15 20:00:00", "2020-05-15 20:00:00", "35.87 EUR");

        var result = PricesRS.toResponse(priceDomain);

        assertEquals(pricesRS, result);
    }
}