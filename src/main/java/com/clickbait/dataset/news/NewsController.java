package com.clickbait.dataset.news;

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
	// 4 subat - 7 mart 2019
	private final NewsService newsService;

	@GetMapping
	@ResponseBody
	public String getHomePage(){
		return "hello";
	}

	//35
	@GetMapping("/naynco")
	@ResponseBody
	public String getNaynCoNews(){
		try {
			newsService.save(newsService.getNaynCoNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//61
	@GetMapping("/evrenselnet")
	@ResponseBody
	public String getEvrenselNetNews(){
		try {
			newsService.save(newsService.getEvrenselNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//1124
	@GetMapping("/dikencomtr")
	@ResponseBody
	public String getDikenComTrNews(){
		try {
			newsService.save(newsService.getDikenNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//1733
	@GetMapping("/yenisafakcom")
	@ResponseBody
	public String getYeniSafakComNews(){
		try {
			newsService.save(newsService.getYeniSafakNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	//3698
	@GetMapping("/trthabercom")
	@ResponseBody
	public String getTrtHaberComNews(){
		try {
			newsService.save(newsService.getTrtHaberNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	//4500
	@GetMapping("/cnnturkcom")
	@ResponseBody
	public String getCnnTurkComNews(){
		try {
			newsService.save(newsService.getCnnTurkNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//11150
	@GetMapping("/hurriyetcomtr")
	@ResponseBody
	public String getHurriyetComTrNews(){
		try {
			newsService.save(newsService.getHurriyetNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//11540
	@GetMapping("/milliyetcomtr")
	@ResponseBody
	public String getMillyetComTrNews(){
		try {
			newsService.save(newsService.getMilliyetNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//17440
	@GetMapping("/sabahcomtr")
	@ResponseBody
	public String getSabahComTrNews(){
		try {
			newsService.save(newsService.getSabahNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	//22848
	@GetMapping("/cumhuriyetcomtr")
	@ResponseBody
	public String getCumhuriyetComTrNews(){
		try {
			newsService.save(newsService.getCumhuriyetNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//24237
	@GetMapping("/sozcucomtr")
	@ResponseBody
	public String getSozcuComTrNews(){
		try {
			newsService.save(newsService.getSozcuNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//24315
	@GetMapping("/t24comtr")
	@ResponseBody
	public String getT24ComTrNews(){
		try {
			newsService.save(newsService.getT24News());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//38178
	@GetMapping("/haberturkcom")
	@ResponseBody
	public String getHaberturkComNews(){
		try {
			newsService.save(newsService.getHaberturkNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//42659
	@GetMapping("/ntvcomtr")
	@ResponseBody
	public String getNtvComTrNews(){
		try {
			newsService.save(newsService.getNtvNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//42957
	@GetMapping("/postacomtr")
	@ResponseBody
	public String getPostaComTrNews(){
		try {
			newsService.save(newsService.getPostaNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//43017
	@GetMapping("/tgrthabercomtr")
	@ResponseBody
	public String getTgrtHaberComTrNews(){
		try {
			newsService.save(newsService.getTgrtHaberNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//49277
	@GetMapping("/turkiyegazetesicomtr")
	@ResponseBody
	public String getTurkiyeGazetesiComTrNews(){
		try {
			newsService.save(newsService.getTurkiyeGazetesiNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//52191
	@GetMapping("/ahabercomtr")
	@ResponseBody
	public String getAHaberComTrNews(){
		try {
			newsService.save(newsService.getAHaberNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//52285
	@GetMapping("/aksamcomtr")
	@ResponseBody
	public String getAksamComTrNews(){
		try {
			newsService.save(newsService.getAksamNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	//52636
	@GetMapping("/birgunnet")
	@ResponseBody
	public String getBirgunNetNews(){
		try {
			newsService.save(newsService.getBirgunNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//52725
	@GetMapping("/gunescom")
	@ResponseBody
	public String getGunesComNews(){
		try {
			newsService.save(newsService.getGunesNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//59792
	@GetMapping("/haber7com")
	@ResponseBody
	public String getHaber7ComNews(){
		try {
			newsService.save(newsService.getHaber7News());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}

	//62968
	@GetMapping("/ntvspornet")
	@ResponseBody
	public String getNtvSporNetNews(){
		try {
			newsService.save(newsService.getNtvSporNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//63030
	@GetMapping("/fanatikcomtr")
	@ResponseBody
	public String getFanatikComTrNews(){
		try {
			newsService.save(newsService.getFanatikNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//63052
	@GetMapping("/abcgazetesicom")
	@ResponseBody
	public String getAbcGazetesiComNews(){
		try {
			newsService.save(newsService.getAbcGazetesiNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//63409
	@GetMapping("/odatvcom")
	@ResponseBody
	public String getOdaTvComNews(){
		try {
			newsService.save(newsService.getOdaTvNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//69360
	@GetMapping("/gercekgundemcom")
	@ResponseBody
	public String getGercekGundemComNews(){
		try {
			newsService.save(newsService.getGercekGundemNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//69765
	@GetMapping("/medyatavacom")
	@ResponseBody
	public String getMedyaTavaComNews(){
		try {
			newsService.save(newsService.getMedyaTavaNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//69862
	@GetMapping("/internethabercom")
	@ResponseBody
	public String getInternetHaberComNews(){
		try {
			newsService.save(newsService.getInternetHaberNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//72630
	@GetMapping("/fotomaccomtr")
	@ResponseBody
	public String getFotomacComTrNews(){
		try {
			newsService.save(newsService.getFotomacNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}
	//74161
	@GetMapping("/takvimcomtr")
	@ResponseBody
	public String getTakvimComTrNews(){
		try {
			newsService.save(newsService.getTakvimNews());
		}
		catch (Exception e){
			return "islem basarisiz!";
		}
		return "islem basarili!";
	}





}
