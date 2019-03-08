package com.clickbait.dataset.news;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Repository
interface NewsRepository extends CrudRepository<News, Long> {

}
