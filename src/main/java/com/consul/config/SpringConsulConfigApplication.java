package com.consul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value = AppConfig.class)
public class SpringConsulConfigApplication {

//	@Value("${spring.app.username}")
//	private String userName;
//	
//	@Value("${spring.app.password}")
//	private String password;
	
	@Autowired
	private AppConfig appConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConsulConfigApplication.class, args);
	}
	
	@GetMapping("/user")
	public String getValue() {
		return "Welcome " + appConfig.getPassword();
	}

}
