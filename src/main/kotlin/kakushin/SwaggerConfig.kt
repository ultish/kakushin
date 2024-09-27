package kakushin


import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun usersMicroserviceOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Users API")
                    .description("Spring Boot application for managing users")
                    .version("1.0")
            )
    }
}