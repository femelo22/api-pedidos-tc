package com.br.tc.adapters.dtos.product;

import com.fastfood.api.core.model.enums.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id,
        ProductCategory category,
        String name,
        BigDecimal price,
        String description,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
