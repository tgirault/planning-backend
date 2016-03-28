package com.girault.thomas.planning.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.girault.thomas.planning.web.repositories")
@EntityScan(basePackages = "com.girault.thomas.planning.web.domains")
@ComponentScan({ "com.girault.thomas.planning.web.controller", "com.girault.thomas.planning.web.services" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:9000");
			}
		};
	}
}
