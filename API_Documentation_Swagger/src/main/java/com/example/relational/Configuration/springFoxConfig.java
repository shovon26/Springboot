package com.example.relational.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class springFoxConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.example.relational"))  //Here provide your projects Controller Package location
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Api Documentation",
                "Api Documentation for One to One Relationship",
                "1.0",
                "Terms of Service",
//                new Contact("Shahriyar", "https://github.com/shovon26/Springboot", "demo@gmail.com"),
                "Shahriyar",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0"
        );
        return apiInfo;
    }

}
