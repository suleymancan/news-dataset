package com.clickbait.dataset.news;

import com.clickbait.dataset.config.ConfigurationPropertyApp;
import com.clickbait.dataset.webhose.WebhoseIOClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
@Slf4j
public class NewsService {

	private final NewsRepository newsRepository;

	private final ConfigurationPropertyApp configurationPropertyApp;

	void saveAll(final List<News> newsList) {
		newsRepository.saveAll(newsList);
	}

	private List<News> getNews(Map<String, String> queries, Integer clickbait) {
		final List<News> newsList = new ArrayList<>();
		try {
			final WebhoseIOClient webhoseIOClient = WebhoseIOClient.getInstance(configurationPropertyApp.getApiKey());
			JsonElement result = webhoseIOClient.query("filterWebContent", queries);
			int i = 0;
			final int totalResults = Integer.parseInt(((JsonObject) result).get("totalResults").toString());
			while (i < totalResults) {
				final JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");
				for (JsonElement jsonElement : postArray) {
					// @formatter:off
				newsList.add(News.builder()
									 .title(jsonElement.getAsJsonObject().get("title").toString())
									 .text(jsonElement.getAsJsonObject().get("text").toString())
									 .url(jsonElement.getAsJsonObject().get("thread").getAsJsonObject().get("url").toString())
									 .site(jsonElement.getAsJsonObject().get("thread").getAsJsonObject().get("site").toString())
									 .mainImage(jsonElement.getAsJsonObject().get("thread").getAsJsonObject().get("main_image").toString())
									 .published(jsonElement.getAsJsonObject().get("thread").getAsJsonObject().get("published").toString())
									 .clickbait(clickbait)
									 .build());

						// @formatter:on
					i++;
				}
				result = webhoseIOClient.getNext();
			}
		}
		catch (URISyntaxException e) {
			log.error(e.getMessage(), e);
		}
		catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return newsList;
	}

	List<News> getDikenNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:diken.com.tr");
		queries.put("ts", "1549379993842");
		queries.put("sort", "published");

		return getNews(queries, null);

	}

	List<News> getYeniSafakNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:yenisafak.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549388280174");
		queries.put("sort", "crawled");

		return getNews(queries, null);

	}

	List<News> getTrtHaberNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:trthaber.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549388225718");
		queries.put("sort", "crawled");

		return getNews(queries, null);

	}

	List<News> getCnnTurkNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:cnnturk.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549388130850");
		queries.put("sort", "crawled");

		return getNews(queries, null);

	}

	List<News> getHurriyetNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:hurriyet.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getMilliyetNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:milliyet.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getSozcuNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:sozcu.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getT24News() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:t24.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getPostaNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:posta.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getTgrtHaberNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:tgrthaber.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getAHaberNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:ahaber.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getBirgunNews() {
		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:birgun.net");
		queries.put("ts", "1549366056522");
		queries.put("sort", "published");
		return getNews(queries, null);
	}

	List<News> getHaber7News() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:haber7.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getOdaTvNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:odatv.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getMedyaTavaNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:medyatava.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getTakvimNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:takvim.com.tr");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getSabahNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:sabah.com.tr");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getEuroNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:euronews.com language:turkish");
		queries.put("ts", "1550062269550");
		queries.put("sort", "crawled");

		return getNews(queries, null);

	}

	List<News> getBbcNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:bbc.com language:turkish");
		queries.put("ts", "1550062269550");
		queries.put("sort", "crawled");

		return this.getNews(queries, null);

	}

	public List<News> findAll() {
		return (List<News>) newsRepository.findAll();
	}



}
