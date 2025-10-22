package com.br.tc.adapters.dtos.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoItemDTO {
    private String sku_number;
    private String category;
    private String title;
    private String description;
    private int quantity;
    private String unit_measure;
    private BigDecimal unit_price;
    private BigDecimal total_amount;


}