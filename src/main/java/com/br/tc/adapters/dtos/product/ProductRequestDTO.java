package com.br.tc.adapters.dtos.product;

import com.fastfood.api.core.model.enums.ProductCategory;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "name should not be null or blank")
        String name,
        @NotNull(message = "category should not be null")
        ProductCategory category,
        @NotNull(message = "price should not be null")
        @Digits(integer = 38, fraction = 2, message = "price must have a maximum of 38 whole numbers and 2 decimal places")
        BigDecimal price,
        @NotBlank(message = "description should not be null or blank")
        String description) {
}

