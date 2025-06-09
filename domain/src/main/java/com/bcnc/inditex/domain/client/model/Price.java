package com.bcnc.inditex.domain.client.model;

public record Price(Long id, int brandId, String startDate, String endDate, int priceList, int productId, int priority, Double price, String curr) {
}
