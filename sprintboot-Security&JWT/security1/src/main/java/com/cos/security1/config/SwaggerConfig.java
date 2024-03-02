package com.cos.security1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;

/**
 * @Configuration: 이 클래스가 설정 클래스임을 나타냅니다.
 * @EnableSwagger2: Swagger를 활성화합니다.
 * Docket 빈을 정의하여 Swagger의 설정을 구성합니다.
 * apis: API 문서화 대상이 되는 패키지를 지정합니다.
 * paths: 문서화할 API 경로를 지정합니다.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cos.security1.controller"))
                .paths(PathSelectors.any())
                .build();

    }
}
