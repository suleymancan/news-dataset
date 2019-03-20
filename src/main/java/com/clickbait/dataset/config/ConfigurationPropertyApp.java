package com.clickbait.dataset.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ConfigurationPropertyApp {

	private String apiKey;

	private String naynCo;

	private String evrensel;

	private String dokuzsekiz;
}
