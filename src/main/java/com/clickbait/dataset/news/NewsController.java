package com.clickbait.dataset.news;

import com.clickbait.dataset.newscopy.NewsCopyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping
	@ResponseBody
	public String getHomePage() {
		return "hello";
	}

	@GetMapping("/dikencomtr")
	@ResponseBody
	public String getDikenComTrNews() {
		try {
			newsService.save(newsService.getDikenNews());
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
			newsService.save(newsService.getYeniSafakNews());
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
			newsService.save(newsService.getTrtHaberNews());
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
			newsService.save(newsService.getCnnTurkNews());
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
			newsService.save(newsService.getHurriyetNews());
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
			newsService.save(newsService.getMilliyetNews());
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
			newsService.save(newsService.getSozcuNews());
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
			newsService.save(newsService.getT24News());
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
			newsService.save(newsService.getPostaNews());
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
			newsService.save(newsService.getTgrtHaberNews());
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
			newsService.save(newsService.getAHaberNews());
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
			newsService.save(newsService.getBirgunNews());
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
			newsService.save(newsService.getHaber7News());
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
			newsService.save(newsService.getOdaTvNews());
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
			newsService.save(newsService.getMedyaTavaNews());
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
			newsService.save(newsService.getTakvimNews());
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
			newsService.save(newsService.getSabahNews());
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
			newsCopyService.saveNewsCopy(newsService.findAll());
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
			newsService.save(newsService.getEuroNews());
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
			newsService.save(newsService.getBbcNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

}
