package com.clickbait.dataset.news;

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
@ConfigurationProperties(prefix = "web-hose")
@Getter
@Setter
public class Configuration {

	private String apiKey;
}
