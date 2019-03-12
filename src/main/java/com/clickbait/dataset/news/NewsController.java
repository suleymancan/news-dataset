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

	@GetMapping("/naynco")
	@ResponseBody
	public String getNaynCoNews() {
		try {
			newsService.save(newsService.getNaynCoNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/evrenselnet")
	@ResponseBody
	public String getEvrenselNetNews() {
		try {
			newsService.save(newsService.getEvrenselNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
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

	@GetMapping("/cumhuriyetcomtr")
	@ResponseBody
	public String getCumhuriyetComTrNews() {
		try {
			newsService.save(newsService.getCumhuriyetNews());
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

	@GetMapping("/haberturkcom")
	@ResponseBody
	public String getHaberturkComNews() {
		try {
			newsService.save(newsService.getHaberturkNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/ntvcomtr")
	@ResponseBody
	public String getNtvComTrNews() {
		try {
			newsService.save(newsService.getNtvNews());
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

	@GetMapping("/turkiyegazetesicomtr")
	@ResponseBody
	public String getTurkiyeGazetesiComTrNews() {
		try {
			newsService.save(newsService.getTurkiyeGazetesiNews());
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

	@GetMapping("/aksamcomtr")
	@ResponseBody
	public String getAksamComTrNews() {
		try {
			newsService.save(newsService.getAksamNews());
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

	@GetMapping("/gunescom")
	@ResponseBody
	public String getGunesComNews() {
		try {
			newsService.save(newsService.getGunesNews());
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

	@GetMapping("/ntvspornet")
	@ResponseBody
	public String getNtvSporNetNews() {
		try {
			newsService.save(newsService.getNtvSporNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/fanatikcomtr")
	@ResponseBody
	public String getFanatikComTrNews() {
		try {
			newsService.save(newsService.getFanatikNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/abcgazetesicom")
	@ResponseBody
	public String getAbcGazetesiComNews() {
		try {
			newsService.save(newsService.getAbcGazetesiNews());
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

	@GetMapping("/gercekgundemcom")
	@ResponseBody
	public String getGercekGundemComNews() {
		try {
			newsService.save(newsService.getGercekGundemNews());
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

	@GetMapping("/internethabercom")
	@ResponseBody
	public String getInternetHaberComNews() {
		try {
			newsService.save(newsService.getInternetHaberNews());
		}
		catch (Exception e) {
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	@GetMapping("/fotomaccomtr")
	@ResponseBody
	public String getFotomacComTrNews() {
		try {
			newsService.save(newsService.getFotomacNews());
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

}
