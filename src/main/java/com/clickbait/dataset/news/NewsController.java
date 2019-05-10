package com.clickbait.dataset.news;

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
 */
@RestController
@RequestMapping("/news")
@AllArgsConstructor
@Slf4j
public class NewsController {

	private final NewsService newsService;

	@GetMapping
	public String getHomePage() {
		return "hello";
	}

	@GetMapping("/dikencomtr")
	public String getDikenComTrNews() {

		newsService.saveAll(newsService.getDikenNews());

		return "success!";
	}

	@GetMapping("/yenisafakcom")
	public String getYeniSafakComNews() {

		newsService.saveAll(newsService.getYeniSafakNews());
		return "success!";
	}

	@GetMapping("/trthabercom")
	public String getTrtHaberComNews() {
		newsService.saveAll(newsService.getTrtHaberNews());
		return "success!";
	}

	@GetMapping("/cnnturkcom")
	public String getCnnTurkComNews() {
		newsService.saveAll(newsService.getCnnTurkNews());
		return "success!";
	}

	@GetMapping("/hurriyetcomtr")
	public String getHurriyetComTrNews() {
		newsService.saveAll(newsService.getHurriyetNews());
		return "success!";
	}

	@GetMapping("/milliyetcomtr")
	public String getMillyetComTrNews() {
		newsService.saveAll(newsService.getMilliyetNews());
		return "success!";
	}

	@GetMapping("/sozcucomtr")
	public String getSozcuComTrNews() {
		newsService.saveAll(newsService.getSozcuNews());
		return "success!";
	}

	@GetMapping("/t24comtr")
	public String getT24ComTrNews() {
		newsService.saveAll(newsService.getT24News());
		return "success!";
	}

	@GetMapping("/postacomtr")
	public String getPostaComTrNews() {
		newsService.saveAll(newsService.getPostaNews());
		return "success!";
	}

	@GetMapping("/tgrthabercomtr")
	public String getTgrtHaberComTrNews() {
		newsService.saveAll(newsService.getTgrtHaberNews());
		return "success!";
	}

	@GetMapping("/ahabercomtr")
	public String getAHaberComTrNews() {
		newsService.saveAll(newsService.getAHaberNews());
		return "success!";
	}

	@GetMapping("/birgunnet")
	public String getBirgunNetNews() {
		newsService.saveAll(newsService.getBirgunNews());
		return "success!";
	}

	@GetMapping("/haber7com")
	public String getHaber7ComNews() {
		newsService.saveAll(newsService.getHaber7News());
		return "success!";
	}

	@GetMapping("/odatvcom")
	public String getOdaTvComNews() {
		newsService.saveAll(newsService.getOdaTvNews());
		return "success!";
	}

	@GetMapping("/medyatavacom")
	public String getMedyaTavaComNews() {

		newsService.saveAll(newsService.getMedyaTavaNews());

		return "success!";
	}

	@GetMapping("/takvimcomtr")
	public String getTakvimComTrNews() {

		newsService.saveAll(newsService.getTakvimNews());

		return "success!";
	}

	@GetMapping("/sabahcomtr")
	public String getSabahComTrNews() {

		newsService.saveAll(newsService.getSabahNews());

		return "success!";
	}

	@GetMapping("/euronewscom")
	public String getEuronewsComNews() {

		newsService.saveAll(newsService.getEuroNews());

		return "success!";
	}

	@GetMapping("/bbccom")
	public String getBbcComNews() {
		final List<News> bbcNews = newsService.getBbcNews();
		newsService.saveAll(bbcNews);
		return "success!";
	}

}
