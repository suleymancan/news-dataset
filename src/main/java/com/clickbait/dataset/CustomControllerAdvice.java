package com.clickbait.dataset;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created on May, 2019
 *
 * @author suleymancan
 */
@ControllerAdvice
@Slf4j
public class CustomControllerAdvice {


	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) throws Exception {
		log.info(e.getMessage(), e);
		throw e;
	}
}
