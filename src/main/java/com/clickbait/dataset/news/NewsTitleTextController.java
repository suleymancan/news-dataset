package com.clickbait.dataset.news;

import com.clickbait.dataset.config.ConfigurationPropertyApp;
import com.clickbait.dataset.titleandsite.TitleAndSiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 *
 * This class, saves the information obtained as a result of web scraping in the database.
 * Web scraping process was done with python and the results were recorded in text file.
 */
@Controller
@RequestMapping("/news/text")
@AllArgsConstructor
public class NewsTitleTextController {

	private final TitleAndSiteService titleAndSiteService;

	private final ConfigurationPropertyApp configurationPropertyApp;

	@GetMapping("/naynco")
	@ResponseBody
	public String getNaynCoTxt(){
		try {
			titleAndSiteService.save(titleAndSiteService.readTxt(configurationPropertyApp.getNaynCo()), "nayn.co");
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/evrensel")
	@ResponseBody
	public String getEvrenselTxt(){
		try {
			titleAndSiteService.save(titleAndSiteService.readTxt(configurationPropertyApp.getEvrensel()), "evrensel.net");
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}


	@GetMapping("/dokuzsekiz")
	@ResponseBody
	public String getDokuzSekizTxt(){
		try {
			titleAndSiteService.save(titleAndSiteService.readTxt(configurationPropertyApp.getDokuzsekiz()), "dokuz8haber.net");
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
}
