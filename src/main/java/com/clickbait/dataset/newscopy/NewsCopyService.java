package com.clickbait.dataset.newscopy;

import com.clickbait.dataset.news.News;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class NewsCopyService {

	private final NewsCopyRepository newsCopyRepository;

	private void save(NewsCopy newsCopy) {
		newsCopyRepository.save(newsCopy);
	}

	public void saveNewsCopy(List<News> newsList) {

		newsList.forEach((news) -> {
			//@formatter:off
			final NewsCopy newsCopy = NewsCopy.builder()
					.title(news.getTitle())
					.text(news.getText())
					.url(news.getUrl())
					.site(news.getSite())
					.mainImage(news.getMainImage())
					.published(news.getPublished())
					.clickbait(news.getClickbait())
					.build();
			//@formatter:on
			this.save(newsCopy);
		});

	}

}
