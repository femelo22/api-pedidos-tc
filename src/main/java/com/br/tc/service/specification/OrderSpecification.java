package com.br.tc.service.specification;

import com.fastfood.api.adapters.driven.entities.ClientEntity;
import com.fastfood.api.adapters.driven.entities.OrderEntity;
import com.fastfood.api.adapters.dtos.order.OrderFilter;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class OrderSpecification extends BaseSpecification<OrderEntity, OrderFilter> {

    private static final String ATTR_ID = "id";
    private static final String ATTR_STATUS = "status";
    private static final String ATTR_ORDER_CPF = "cpf";
    private static final String ATTR_TOTAL_PRICE = "totalPrice";
    private static final String ATTR_DATE = "date";
    private static final String ATTR_CLIENT = "client";
    private static final String CLIENT_ATTR_ID = "id";
    private static final String CLIENT_ATTR_NAME = "name";
    private static final String CLIENT_ATTR_CPF = "cpf";
    private static final String CLIENT_ATTR_EMAIL = "email";
    private static final String CLIENT_ATTR_PHONE = "phone";

    private Join<OrderEntity, ClientEntity> clientJoin;

    @Override
    public Specification<OrderEntity> getFilter(OrderFilter filter) {
        return (root, query, cb) ->
                where(attributeEquals(ATTR_ID, filter.getId()))
                        .and(attributeEquals(ATTR_ORDER_CPF, filter.getOrderCpf()))
                        .and(attributeLessThan(ATTR_TOTAL_PRICE, filter.getTotalPriceLessThan()))
                        .and(attributeGreaterThan(ATTR_TOTAL_PRICE, filter.getTotalPriceGreaterThan()))
                        .and(attributeDateBetween(ATTR_DATE, filter.getDateFrom(), filter.getDateTo()))
                        .and(clientAttributeEquals(CLIENT_ATTR_ID, Objects.nonNull(filter.getClient()) ? filter.getClient().id() : null))
                        .and(clientAttributeContains(CLIENT_ATTR_NAME, Objects.nonNull(filter.getClient()) ? filter.getClient().name() : null))
                        .and(clientAttributeEquals(CLIENT_ATTR_CPF, Objects.nonNull(filter.getClient()) ? filter.getClient().cpf() : null))
                        .and(clientAttributeEquals(CLIENT_ATTR_EMAIL, Objects.nonNull(filter.getClient()) ? filter.getClient().email() : null))
                        .and(clientAttributeEquals(CLIENT_ATTR_PHONE, Objects.nonNull(filter.getClient()) ? filter.getClient().phone() : null))
                        .and(attributeNotEquals(ATTR_STATUS, filter.getStatusNotEquals()))
                        .toPredicate(root, query, cb);
    }

    private Specification<OrderEntity> attributeEquals(String attribute, Object value) {
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

    private Specification<OrderEntity> attributeNotEquals(String attribute, Object value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.notEqual(
                    root.get(attribute),
                    value
            );
        };
    }

    private Specification<OrderEntity> attributeLessThan(String attribute, BigDecimal value) {
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

    private Specification<OrderEntity> attributeGreaterThan(String attribute, BigDecimal value) {
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

    private Specification<OrderEntity> attributeDateBetween(String attribute, LocalDate dtFrom, LocalDate dtTo) {
        return (root, query, cb) -> {
            if (dtFrom == null || dtTo == null) {
                return null;
            }
            return cb.between(cb.function("DATE", LocalDate.class, root.get(attribute)), dtFrom, dtTo);
        };
    }

    private Specification<OrderEntity> clientAttributeEquals(String attribute, Long value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.equal(
                    getClientJoin(root).get(attribute),
                    value
            );
        };
    }

    private Specification<OrderEntity> clientAttributeEquals(String attribute, String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.equal(
                    getClientJoin(root).get(attribute),
                    value
            );
        };
    }

    private Specification<OrderEntity> clientAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.like(
                    cb.lower(getClientJoin(root).get(attribute)),
                    containsLowerCase(value)
            );
        };
    }

    public Join<OrderEntity, ClientEntity> getClientJoin(Root<OrderEntity> root) {
        return (clientJoin == null) ? root.join(ATTR_CLIENT, JoinType.INNER) : clientJoin;
    }
}
