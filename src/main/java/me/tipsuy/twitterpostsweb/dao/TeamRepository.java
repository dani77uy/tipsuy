package me.tipsuy.twitterpostsweb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.tipsuy.twitterpostsweb.model.TeamBean;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@Repository
public interface TeamRepository extends CrudRepository<TeamBean, Long> {

}
