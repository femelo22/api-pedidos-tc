package com.br.tc.adapters.dtos.product;

import com.fastfood.api.core.model.enums.ProductCategory;

import java.math.BigDecimal;

public record ProductFilter(
        Long id,
        ProductCategory category,
        String name,
        BigDecimal priceLessThan,
        BigDecimal priceGreaterThan,
        String description,
        Boolean active) {

}
