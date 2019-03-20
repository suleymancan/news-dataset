package com.clickbait.dataset.titleandsite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Repository
interface TitleAndSiteRepository extends CrudRepository<TitleAndSite, Long> {

}
