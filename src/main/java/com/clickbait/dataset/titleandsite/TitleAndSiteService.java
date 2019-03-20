package com.clickbait.dataset.titleandsite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class TitleAndSiteService {

	private final TitleAndSiteRepository titleAndSiteRepository;

	private void save(TitleAndSite titleAndSite){
		 titleAndSiteRepository.save(titleAndSite);
	}

	public List<String> readTxt(String path){
		List<String> newsList = new ArrayList<>();
		try{
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String news;
			while((news = bufferedReader.readLine()) != null){
				newsList.add(news);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return newsList;
	}

	public void save(List<String> titleList, String site){
		titleList.forEach(title -> {
			TitleAndSite titleAndSite = new TitleAndSite(title, site, 0);
			this.save(titleAndSite);
		});
	}


}
