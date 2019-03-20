package com.clickbait.dataset;

import com.clickbait.dataset.config.ConfigurationPropertyApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigurationPropertyApp.class)
public class DatasetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasetApplication.class, args);
	}

}
