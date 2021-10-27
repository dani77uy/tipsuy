package me.tipsuy.twitterpostsweb.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.tipsuy.twitterpostsweb.dao.TeamRepository;
import me.tipsuy.twitterpostsweb.model.exception.ErrorCode;
import me.tipsuy.twitterpostsweb.model.exception.TwitterPostException;
import me.tipsuy.twitterpostsweb.model.web.TeamBean;
import me.tipsuy.twitterpostsweb.service.TeamService;

/**
 * @author Daniel Baharian
 * @since 24 oct. 2021
 */
@Component
public class TeamServiceImpl implements TeamService {


   @Autowired
   TeamRepository teamRepository;

   @Override
   public TeamBean findById(long id) throws TwitterPostException {
      final var t = teamRepository.findById(id);
      return t.orElseThrow(() -> new TwitterPostException(ErrorCode.INVALID_TEAM));
   }

   @Override
   public Collection<TeamBean> findAll() {
      final var it = teamRepository.findAll();
      return StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
   }
}
