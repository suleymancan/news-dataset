package com.clickbait.dataset.newscopy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Repository
interface NewsCopyRepository extends CrudRepository<NewsCopy, Long> {

}
