package com.br.tc.infrastructure.http;

import com.br.tc.adapters.dtos.order.OrderPayment;
import com.br.tc.core.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-pagamentos", path = "${url.api-pagamento}")
public interface PaymentClient {

    @PostMapping("/pagamento")
    String enviarPagamento(@RequestBody OrderPayment newPayment);

    @PutMapping("/atualizar")
    Payment updatePayment(@RequestBody Payment payment);
}
