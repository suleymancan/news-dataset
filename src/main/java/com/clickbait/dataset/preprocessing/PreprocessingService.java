package com.clickbait.dataset.preprocessing;

import com.clickbait.dataset.config.ConfigurationPropertyApp;
import com.clickbait.dataset.titleandsite.TitleAndSiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class PreprocessingService {

	private final TitleAndSiteService titleAndSiteService;

	private final ConfigurationPropertyApp configurationPropertyApp;

	public void createTxtFile(int fileSize, boolean clickbaitOrNonClickbait) {
		final String path = this.getPathName(clickbaitOrNonClickbait);
		int i = 1;
		while (i <= fileSize) {
			final Path newFilePath = Paths.get(path + i + ".txt");
			try {
				Files.createFile(newFilePath);
				i++;
			}
			catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	private String getPathName(boolean clickbaitOrNonClickbait) {
		final String path;
		if (clickbaitOrNonClickbait) {
			path = configurationPropertyApp.getTxtPath() + "/1/";
		}
		else {
			path = configurationPropertyApp.getTxtPath() + "/0/";
		}
		return path;
	}

	public void writeTxtFile(List<String> titleList, boolean clickbaitOrNonClickbait) {
		final String path = this.getPathName(clickbaitOrNonClickbait);
		int pathNumber = 1;
		int j = 0;
		while (j < titleList.size()) {
			final Path writePath = Paths.get(path + pathNumber + ".txt");
			final byte[] titleBytes = titleList.get(j).getBytes();
			try {
				Files.write(writePath, titleBytes);
				pathNumber++;
				j++;
			}
			catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

}
