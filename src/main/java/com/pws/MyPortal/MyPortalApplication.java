package com.pws.MyPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class MyPortalApplication {

	/*@CrossOrigin(origins="http://localhost:9090")*/
	@GetMapping("/access")
	public String greeting() {
		return "Welcome";
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:9090");
			}

		};
	}


	public static void main(String[] args) {
		SpringApplication.run(MyPortalApplication.class, args);
	}

}
