package com.clickbait.dataset.titleandsite;

import com.clickbait.dataset.config.ConfigurationPropertyApp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 * <p>
 * This class, saves the information obtained as a result of web scraping in the database.
 * Web scraping process was done with python and the results were recorded in text file.
 */
@RestController
@RequestMapping("/news/text")
@AllArgsConstructor
@Slf4j
public class NewsTitleTextController {

	private final TitleAndSiteService titleAndSiteService;

	private final ConfigurationPropertyApp configurationPropertyApp;

	@GetMapping("/naynco")
	public String getNaynCoTxt() {

		final List<String> titleList = titleAndSiteService.readTxt(configurationPropertyApp.getNaynCo());
		final List<TitleAndSite> titleAndSiteList = titleAndSiteService.save(titleList, "nayn.co");
		titleAndSiteService.saveAll(titleAndSiteList);

		return "success!";
	}

	@GetMapping("/evrensel")
	public String getEvrenselTxt() {

		final List<String> titleList = titleAndSiteService.readTxt(configurationPropertyApp.getEvrensel());
		final List<TitleAndSite> titleAndSiteList = titleAndSiteService.save(titleList, "evrensel.net");
		titleAndSiteService.saveAll(titleAndSiteList);

		return "success!";
	}

	@GetMapping("/dokuzsekiz")
	public String getDokuzSekizTxt() {

		final List<String> titleList = titleAndSiteService.readTxt(configurationPropertyApp.getDokuzsekiz());
		final List<TitleAndSite> titleAndSiteList = titleAndSiteService.save(titleList, "dokuz8haber.net");
		titleAndSiteService.saveAll(titleAndSiteList);

		return "success!";
	}

}
