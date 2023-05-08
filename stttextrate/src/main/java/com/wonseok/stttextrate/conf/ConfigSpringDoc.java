package com.wonseok.stttextrate.conf;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSpringDoc {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .components(new Components().addSecuritySchemes("basicSchema", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info().title("STT 분석 API")
                        .description("STT TEXT 정답지 대비 일치율 분석 API")
                        .version("v0.0.1")
                        .license(new License().name("ICOMSYS").url("http://www.icomsys.co.kr/"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("JangWonSeok Developer")
                        .url("https://github.com/No1stone/record")
                )
                ;
    }



    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("analysis-public")
                .pathsToMatch("/api/v1/analysis/**")
                .build();
    }
    /*
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("springshop-admin")
                .pathsToMatch("/admin/**")
//                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }
    */
}
