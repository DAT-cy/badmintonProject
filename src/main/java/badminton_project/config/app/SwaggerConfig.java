package badminton_project.config.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "CY",
                        email = "",
                        url = ""
                ),
                termsOfService = "Terms of service",
                title = "Spring boot API",
                description = "API Document",
                version = "v0.1"
        ),
        servers = {
                @Server(
                        description = "LOCAL ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "DEV ENV",
                        url = "http://dev.localhost:8080"
                ),
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}