package com.blog.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
            .components(new Components())
            .servers(server())
            .info(info());
    }

    @Bean
    List<Server> server(){
        return List.of(new Server().description("로컬 서버").url("http://3.37.125.9:8000"));
    }

    @Bean
    Info info(){
        return new Info()
        .title("블로그 개발")
        .version("x.xx")
        .description("description");
    }
}
