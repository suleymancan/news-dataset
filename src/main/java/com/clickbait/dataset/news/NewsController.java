package com.clickbait.dataset.news;

import com.clickbait.dataset.newscopy.NewsCopy;
import com.clickbait.dataset.newscopy.NewsCopyService;
import com.clickbait.dataset.titleandsite.TitleAndSiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Controller
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {

	private final NewsService newsService;

	private final NewsCopyService newsCopyService;

	private final TitleAndSiteService titleAndSiteService;

	@GetMapping
	@ResponseBody
	public String getHomePage() {
		return "hello";
	}

	@GetMapping("/dikencomtr")
	@ResponseBody
	public String getDikenComTrNews() {
		try {
			newsService.saveAll(newsService.getDikenNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/yenisafakcom")
	@ResponseBody
	public String getYeniSafakComNews() {
		try {
			newsService.saveAll(newsService.getYeniSafakNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/trthabercom")
	@ResponseBody
	public String getTrtHaberComNews() {
		try {
			newsService.saveAll(newsService.getTrtHaberNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/cnnturkcom")
	@ResponseBody
	public String getCnnTurkComNews() {
		try {
			newsService.saveAll(newsService.getCnnTurkNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/hurriyetcomtr")
	@ResponseBody
	public String getHurriyetComTrNews() {
		try {
			newsService.saveAll(newsService.getHurriyetNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/milliyetcomtr")
	@ResponseBody
	public String getMillyetComTrNews() {
		try {
			newsService.saveAll(newsService.getMilliyetNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/sozcucomtr")
	@ResponseBody
	public String getSozcuComTrNews() {
		try {
			newsService.saveAll(newsService.getSozcuNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/t24comtr")
	@ResponseBody
	public String getT24ComTrNews() {
		try {
			newsService.saveAll(newsService.getT24News());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/postacomtr")
	@ResponseBody
	public String getPostaComTrNews() {
		try {
			newsService.saveAll(newsService.getPostaNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/tgrthabercomtr")
	@ResponseBody
	public String getTgrtHaberComTrNews() {
		try {
			newsService.saveAll(newsService.getTgrtHaberNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/ahabercomtr")
	@ResponseBody
	public String getAHaberComTrNews() {
		try {
			newsService.saveAll(newsService.getAHaberNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/birgunnet")
	@ResponseBody
	public String getBirgunNetNews() {
		try {
			newsService.saveAll(newsService.getBirgunNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/haber7com")
	@ResponseBody
	public String getHaber7ComNews() {
		try {
			newsService.saveAll(newsService.getHaber7News());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/odatvcom")
	@ResponseBody
	public String getOdaTvComNews() {
		try {
			newsService.saveAll(newsService.getOdaTvNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/medyatavacom")
	@ResponseBody
	public String getMedyaTavaComNews() {
		try {
			newsService.saveAll(newsService.getMedyaTavaNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/takvimcomtr")
	@ResponseBody
	public String getTakvimComTrNews() {
		try {
			newsService.saveAll(newsService.getTakvimNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/sabahcomtr")
	@ResponseBody
	public String getSabahComTrNews() {
		try {
			newsService.saveAll(newsService.getSabahNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/newscopy")
	@ResponseBody
	public String saveNewsCopy() {
		try {
			final List<News> newsList = newsService.findAll();
			final List<NewsCopy> newsCopyList = newsCopyService.saveNewsCopy(newsList);
			newsCopyService.saveAll(newsCopyList);
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/euronewscom")
	@ResponseBody
	public String getEuronewsComNews() {
		try {
			newsService.saveAll(newsService.getEuroNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/bbccom")
	@ResponseBody
	public String getBbcComNews() {
		try {
			newsService.saveAll(newsService.getBbcNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/copy")
	@ResponseBody
	public String convertNewsToTitleAndSite(){
		try{
			final List<News> news = newsService.findAll();
			titleAndSiteService.saveAll(titleAndSiteService.convertNewsToTitleAndSite(news));
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

}
