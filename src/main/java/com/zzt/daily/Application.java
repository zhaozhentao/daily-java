package com.zzt.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by zhaotao on 2017/6/12.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean()
    public ServletContextTemplateResolver templateResolver() {
        final ServletContextTemplateResolver resolver =
            new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
