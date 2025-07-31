package io.github.smfmo.desafio_anota_ai.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
              title = "Desafio Anota ai - Pleno ",
              version = "V1",
              contact = @Contact(
                      name = "Samuel Monteiro Ferreira",
                      email = "smf.ferreira1901@gmail.com",
                      url = "https://github.com/smfmo/desafio-anotaAi-Pleno-estudo"
              )
        )
)
public class OpenApiConfig {
}
