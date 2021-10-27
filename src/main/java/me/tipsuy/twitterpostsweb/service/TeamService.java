package me.tipsuy.twitterpostsweb.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import me.tipsuy.twitterpostsweb.model.exception.TwitterPostException;
import me.tipsuy.twitterpostsweb.model.web.TeamBean;

/**
 * @author Daniel Baharian
 * @since 24 oct. 2021
 */
@Service
public interface TeamService {

   TeamBean findById(long id) throws TwitterPostException;

   Collection<TeamBean> findAll();

}
