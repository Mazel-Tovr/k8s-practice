package com.mazeltov.sample.configure

import org.springframework.beans.factory.annotation.*
import org.springframework.context.annotation.*
import springfox.documentation.builders.*
import springfox.documentation.builders.PathSelectors.*
import springfox.documentation.spi.*
import springfox.documentation.spring.web.plugins.*
import java.util.function.*

@Configuration
class SwaggerConfig {
    @Bean
    fun api(): Docket {

        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(paths())
            .build()
    }

    @Value("\${api.cat.rout}")
    private lateinit var cats: String

    private fun paths(): Predicate<String> {
        return regex("/.*")
            .or(regex("$cats.*"))
    }
}
