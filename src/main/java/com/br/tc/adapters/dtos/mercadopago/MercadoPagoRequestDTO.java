package com.br.tc.adapters.dtos.mercadopago;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class MercadoPagoRequestDTO {
    private String external_reference;
    private String notification_url;
    private BigDecimal total_amount;
    private List<MercadoPagoItemDTO> items;
    private String title;
    private String description;

}
