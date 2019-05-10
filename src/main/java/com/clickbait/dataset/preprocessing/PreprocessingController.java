package com.clickbait.dataset.preprocessing;

import com.clickbait.dataset.titleandsite.TitleAndSiteService;
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
@RequestMapping("/pre")
@AllArgsConstructor
@Slf4j
public class PreprocessingController {

	private final PreprocessingService preprocessingService;

	private final TitleAndSiteService titleAndSiteService;

	@GetMapping("/create-file")
	public String createFile() {

		final List<String> allTitleByNonClickbait = titleAndSiteService.findAllTitleByClickbait(0);
		preprocessingService.createTxtFile(allTitleByNonClickbait.size(), false);
		final List<String> allTitleByClickbait = titleAndSiteService.findAllTitleByClickbait(1);
		preprocessingService.createTxtFile(allTitleByClickbait.size(), true);

		return "success";
	}

	@GetMapping("/write-file")
	public String writeFile() {

		final List<String> allTitleByNonClickbait = titleAndSiteService.findAllTitleByClickbait(0);
		preprocessingService.writeTxtFile(allTitleByNonClickbait, false);
		final List<String> allTitleByClickbait = titleAndSiteService.findAllTitleByClickbait(1);
		preprocessingService.writeTxtFile(allTitleByClickbait, true);

		return "success";
	}

}
