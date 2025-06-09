package com.bcnc.inditex.application.client.adapter;

import com.bcnc.inditex.application.client.port.PricePort;
import com.bcnc.inditex.domain.client.model.Price;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PriceInteractionAdapterTest {

    private final PricePort pricePort = mock(PricePort.class);
    private final PriceInteractionAdapter sut = new PriceInteractionAdapter(pricePort);

    @Test
    void find_whenPortReturnElements_thenReturnCorrectly() {
        var expectedPrice = new Price(1L, 1, "2020-05-15 20:00:00", "2020-05-16 00:00:00",1, 35455, 0, 35.87, "EUR");
        doReturn(expectedPrice).when(pricePort).find(any(Timestamp.class), anyInt(), anyInt());

        var result = sut.find(Timestamp.valueOf("2020-05-15 21:00:00"), 1, 35455);

        assertEquals(expectedPrice, result);
    }
}
