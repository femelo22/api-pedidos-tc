package com.br.tc.service.specification;

import com.fastfood.api.adapters.driven.entities.ProductEntity;
import com.fastfood.api.adapters.dtos.product.ProductFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class ProductSpecification extends BaseSpecification<ProductEntity, ProductFilter> {

    private static final String ATTR_ID = "id";
    private static final String ATTR_CATEGORY = "category";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PRICE = "price";
    private static final String ATTR_ACTIVE = "active";
    private static final String ATT_DESCRIPTION = "description";

    @Override
    public Specification<ProductEntity> getFilter(ProductFilter filter) {
        return (root, query, cb) ->
                where(attributeEquals(ATTR_ID, filter.id()))
                        .and(attributeEquals(ATTR_CATEGORY, filter.category()))
                        .and(attributeContains(ATTR_NAME, filter.name()))
                        .and(attributeLessThan(ATTR_PRICE, filter.priceLessThan()))
                        .and(attributeGreaterThan(ATTR_PRICE, filter.priceGreaterThan()))
                        .and(attributeContains(ATT_DESCRIPTION, filter.description()))
                        .and(attributeEquals(ATTR_ACTIVE, filter.active()))
                        .toPredicate(root, query, cb);
    }

    private Specification<ProductEntity> attributeEquals(String attribute, Object value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.equal(
                    root.get(attribute),
                    value
            );
        };
    }

    private Specification<ProductEntity> attributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }

    private Specification<ProductEntity> attributeLessThan(String attribute, BigDecimal value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.lessThan(
                    root.get(attribute),
                    value
            );
        };
    }

    private Specification<ProductEntity> attributeGreaterThan(String attribute, BigDecimal value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.greaterThan(
                    root.get(attribute),
                    value
            );
        };
    }
}
