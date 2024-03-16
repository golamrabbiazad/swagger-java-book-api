package com.golamrabbiazad.swaggerrestapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Book Vendor", description = "Best Books you'll find.", version = "v1")
)
public class OpenAPIConfig { }

