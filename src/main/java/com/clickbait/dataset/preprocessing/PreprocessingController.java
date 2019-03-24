package com.clickbait.dataset.preprocessing;

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
@RequestMapping("/pre")
@AllArgsConstructor
public class PreprocessingController {

	private final PreprocessingService preprocessingService;

	private final TitleAndSiteService titleAndSiteService;

	@GetMapping("/create-file")
	@ResponseBody
	public String createFile() {
		try {
			// TODO: 24.03.2019 total news information can be retrieved from the database. 
			final List<String> allTitleByNonClickbait = titleAndSiteService.findAllTitleByClickbait(0);
			preprocessingService.createTxtFile(allTitleByNonClickbait.size(), false);
			final List<String> allTitleByClickbait = titleAndSiteService.findAllTitleByClickbait(1);
			preprocessingService.createTxtFile(allTitleByClickbait.size(), true);
		}
		catch (Exception e) {
			return "hata!";
		}
		return "başarılı";
	}

	@GetMapping("/write-file")
	@ResponseBody
	public String writeFile() {
		try {
			final List<String> allTitleByNonClickbait = titleAndSiteService.findAllTitleByClickbait(0);
			preprocessingService.writeTxtFile(allTitleByNonClickbait, false);
			final List<String> allTitleByClickbait = titleAndSiteService.findAllTitleByClickbait(1);
			preprocessingService.writeTxtFile(allTitleByClickbait, true);
		}
		catch (Exception e) {
			return "hata!";
		}
		return "başarılı";
	}
}
