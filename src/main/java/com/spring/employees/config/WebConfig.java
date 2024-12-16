package com.spring.employees.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	
	public void addCorsMappings (CorsRegistry registry)
	{
		registry.addMapping("/**").allowedOrigins("http://localhost:4200/employees").allowedMethods("GET","POST","PUT","DELETE");
		registry.addMapping("/**").allowedOrigins("http://localhost:4200/projects").allowedMethods("GET","DELETE","Post","PUT");
	}

}
