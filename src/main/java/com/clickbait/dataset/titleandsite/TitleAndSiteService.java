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


	public void saveAll(List<TitleAndSite> titleAndSites){
		titleAndSiteRepository.saveAll(titleAndSites);
	}


	public List<String> findAllTitleByClickbait(Integer clickbait){
		return titleAndSiteRepository.findAllTitleByClickbait(clickbait);
	}

	// txt dosyadaki verileri okuma.
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

	// txt dosyadaki haberleri veritabanina kaydetme.
	public List<TitleAndSite> save(List<String> titleList, String site){
		List<TitleAndSite> titleAndSiteList = new ArrayList<>();
		titleList.forEach(title -> {
			final TitleAndSite titleAndSite = new TitleAndSite(title, site, 0);
			titleAndSiteList.add(titleAndSite);
		});
		return titleAndSiteList;
	}

	// Haberlerin sadece site ve isimlerini alma.
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
