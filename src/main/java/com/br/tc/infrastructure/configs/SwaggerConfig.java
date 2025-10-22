package com.br.tc.infrastructure.configs;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Fiap Tech Challenge - Fast Food Self-Service")
                .version("1.0")
                .description("""
                        API documentation for Tech Challenge - Fast Food Self-Service.<br>\s
                        System for an expanding snack bar, solving problems related to order control and customer service.\s
                        - Camila Yumi Mandai - RM362670 (camila.mandai@alura.com.br) \s
                        - Carlos Henrique Gomes dos Santos – RM361362 (carlos.hgs@outlook.com.br)\s
                        - José Alves de Oliveira Junior – RM361750 (alves.dev91@gmail.com)\s
                        - Luiz Fernando de Melo Gonçalves - RM361777 (luiz123jfmg@gmail.com)""")
                .contact(new Contact()
                        .name("Pós Tech - Software Architecture")
                        .email("atendimento@fiap.com.b")
                )
        );
    }
}