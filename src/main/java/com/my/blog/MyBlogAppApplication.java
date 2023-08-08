package com.my.blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Blog App",
				description = "Spring Bott App Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sasha",
						email = "sasha@gmail.com",
						url = "https://translate.google.com/?hl=uk&sl=en&tl=uk&op=translate"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.google.com.ua/?hl=uk"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog App Documentation",
				url = "https://translate.google.com/?hl=uk&sl=en&tl=uk&op=translate"
		)
)
public class MyBlogAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBlogAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
