package com.clickbait.dataset.titleandsite;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Repository
interface TitleAndSiteRepository extends CrudRepository<TitleAndSite, Long> {

	@Query("SELECT t.title FROM TitleAndSite t WHERE t.clickbait=:clickbait")
	List<String> findAllTitleByClickbait(Integer clickbait);
}
