package com.br.tc.adapters.dtos.mercadopago;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MerchantOrderDTO {
    private Long id;
    private String order_status;
    private String external_reference;

    public Long getId() {
        return id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getExternal_reference() {
        return external_reference;
    }
}
