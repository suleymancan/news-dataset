package com.clickbait.dataset.news;

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
class NewsService {

	private final NewsRepository newsRepository;

	private final Configuration configuration;

	void save(final List<News> newsList) {
		newsList.forEach((news) -> newsRepository.save(news));
	}

	private List<News> getNews(Map<String, String> queries, Integer clickbait) {
		final List<News> newsList = new ArrayList<>();
		try {
			final WebhoseIOClient webhoseIOClient = WebhoseIOClient.getInstance(configuration.getApiKey());
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

	List<News> getNaynCoNews() {
		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:nayn.co");
		queries.put("ts", "1549366056522");
		queries.put("sort", "published");
		return getNews(queries, 0);
	}

	List<News> getEvrenselNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:evrensel.net");
		queries.put("ts", "1549371978281");
		queries.put("sort", "published");

		return getNews(queries, 0);

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

	List<News> getSabahNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:sabah.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getCumhuriyetNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:cumhuriyet.com.tr language:turkish has_video:false site_type:news thread.country:TR");
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

	List<News> getHaberturkNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:haberturk.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getNtvNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:ntv.com.tr language:turkish has_video:false site_type:news thread.country:TR");
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

	List<News> getTurkiyeGazetesiNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:turkiyegazetesi.com.tr language:turkish has_video:false site_type:news thread.country:TR");
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

	List<News> getAksamNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:aksam.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getBirgunNews() {
		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:birgun.net");
		queries.put("ts", "1549366056522");
		queries.put("sort", "published");
		return getNews(queries, 0);
	}

	List<News> getGunesNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:gunes.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getHaber7News() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:haber7.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getNtvSporNews() {
		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:ntvspor.net");
		queries.put("ts", "1549366056522");
		queries.put("sort", "published");
		return getNews(queries, 0);
	}

	List<News> getFanatikNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:fanatik.com.tr language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getAbcGazetesiNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:abcgazetesi.com");
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

	List<News> getGercekGundemNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:gercekgundem.com");
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

	List<News> getInternetHaberNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:internethaber.com language:turkish has_video:false site_type:news thread.country:TR");
		queries.put("ts", "1549437944172");
		queries.put("sort", "domain_rank");

		return getNews(queries, null);

	}

	List<News> getFotomacNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:fotomac.com.tr language:turkish has_video:false site_type:news thread.country:TR");
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

	List<News> findAll() {
		return (List<News>) newsRepository.findAll();
	}

}
