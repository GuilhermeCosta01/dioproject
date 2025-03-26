package me.dioproject.userFileStorage.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Armazenamento de Arquivos")
                        .version("1.0")
                        .description("Documentação da API para gerenciamento de usuários e arquivos.")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .email("email@meusite.com.br")
                                .url("https://www.meusite.com.br")
                        )
                );
    }
}