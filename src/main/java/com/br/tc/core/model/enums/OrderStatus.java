package com.br.tc.core.model.enums;

public enum OrderStatus {
    RECEIVED(0),
    IN_PROGRESS(1),
    COMPLETED(2),
    FINISHED(3);

    private Integer code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
