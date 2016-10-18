package com.waa.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfiguration {
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter()  {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	final String[] servers = {"http://localhost:9082","http://webapp:9082"};
            	final String[] mappings = {"/hello/**","/team/**","/member/**","/step/**"};
            	for(String server: servers){
	                for (String mapping : mappings) {
	                	registry.addMapping(mapping).allowedOrigins(server).allowedMethods("GET","PUT","POST","DELETE");
					}
            	}
            }
        };
    }
}
