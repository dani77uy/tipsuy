package me.tipsuy.twitterpostsweb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.tipsuy.twitterpostsweb.model.web.FeedBean;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
@Repository
public interface FeedRepository extends CrudRepository<FeedBean, Long> {

}
