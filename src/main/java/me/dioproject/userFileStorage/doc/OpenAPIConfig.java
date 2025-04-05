package me.dioproject.userFileStorage.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

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
                                .name("Guilherme Costa")
                                .email("guilecosta@gmail.com")
                                .url("https://www.guilhermecostadev.com.br")
                        )
                );
    }
}