package com.thanhliem.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "TL_Banks Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Thanh Liem",
                        email = "hatriwi@gmail.com",
                        url = ""
                ),
                license = @License(
                        name = "Apache 3.0",
                        url = ""
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "TL_Banks Loans microservice REST API Documentation",
                url = ""
        )
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
