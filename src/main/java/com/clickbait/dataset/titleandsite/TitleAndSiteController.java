package com.clickbait.dataset.titleandsite;

import com.clickbait.dataset.news.News;
import com.clickbait.dataset.news.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on May, 2019
 *
 * @author suleymancan
 */
@RestController("/title-site")
@AllArgsConstructor
public class TitleAndSiteController {

	private final NewsService newsService;

	private final TitleAndSiteService titleAndSiteService;

	@GetMapping
	public String convertNewsToTitleAndSite() {

		final List<News> news = newsService.findAll();
		titleAndSiteService.saveAll(titleAndSiteService.convertNewsToTitleAndSite(news));
		return "success!";
	}
}
