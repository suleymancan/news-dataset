package com.clickbait.dataset.titleandsite;

import com.clickbait.dataset.news.News;
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

	public void saveAll(List<TitleAndSite> titleAndSites){
		titleAndSiteRepository.saveAll(titleAndSites);
	}

	public List<TitleAndSite> findAll(){
		return (List<TitleAndSite>) titleAndSiteRepository.findAll();
	}

	public List<String> findAllTitleByClickbait(Integer clickbait){
		return titleAndSiteRepository.findAllTitleByClickbait(clickbait);
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

	public List<TitleAndSite> save(List<String> titleList, String site){
		List<TitleAndSite> titleAndSiteList = new ArrayList<>();
		titleList.forEach(title -> {
			final TitleAndSite titleAndSite = new TitleAndSite(title, site, 0);
			titleAndSiteList.add(titleAndSite);
		});
		return titleAndSiteList;
	}

	public List<TitleAndSite> convertNewsToTitleAndSite(List<News> newsList){
		final List<TitleAndSite> titleAndSiteList = new ArrayList<>();
		newsList.forEach((news -> {
			final String title = news.getTitle().substring(1, news.getTitle().length()-1);
			final String site = news.getSite().substring(1, news.getSite().length()-1);
			final TitleAndSite titleAndSite = new TitleAndSite(title, site, news.getClickbait());
			titleAndSiteList.add(titleAndSite);
		}));
		return titleAndSiteList;
	}


}
