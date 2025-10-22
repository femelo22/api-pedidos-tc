package com.br.tc.adapters.dtos.mercadopago;

public class MercadoPagoResponseDTO {
    private String in_store_order_id;
    private String qr_data;

    // getters e setters
    public String getIn_store_order_id() {
        return in_store_order_id;
    }
    public void setIn_store_order_id(String in_store_order_id) {
        this.in_store_order_id = in_store_order_id;
    }
    public String getQr_data() {
        return qr_data;
    }
    public void setQr_data(String qr_data) {
        this.qr_data = qr_data;
    }
}
