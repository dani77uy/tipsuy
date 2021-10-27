package me.tipsuy.twitterpostsweb.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.tipsuy.twitterpostsweb.dao.FeedContentPostRepository;
import me.tipsuy.twitterpostsweb.model.exception.ErrorCode;
import me.tipsuy.twitterpostsweb.model.exception.TwitterPostException;
import me.tipsuy.twitterpostsweb.model.job.Feed;
import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedBean;
import me.tipsuy.twitterpostsweb.model.web.FeedBean;
import me.tipsuy.twitterpostsweb.model.web.TournamentBean;
import me.tipsuy.twitterpostsweb.service.FeedEntryService;
import me.tipsuy.twitterpostsweb.util.APIUtil;
import me.tipsuy.twitterpostsweb.validation.FeedTypeValidator;

/**
 * @author Daniel Baharian
 * @since 25 oct. 2021
 */
@Component
public class FeedEntryServiceImpl implements FeedEntryService {

   @Autowired
   FeedContentPostRepository feedContentPostRepository;

   @Override
   public List<EntryContentPostedBean> checkNewEntryByFeed(FeedBean feedBean, Feed feed) throws TwitterPostException {
      final var result = new LinkedList<EntryContentPostedBean>();
      if (FeedTypeValidator.YOUTUBE.equals(feedBean.getType())) {
         final var ids = new LinkedList<Feed.Entry>();
         final var lastEntriesFeed = feed.getEntry();
         for (Feed.Entry entry : lastEntriesFeed) {
            if (!checkIfEntryLinkIsRegistered(entry.getLink().getHref())) {
               ids.add(entry);
            }
         }
         if (!ids.isEmpty()) {
            ids.forEach(entry -> {
               result.add(APIUtil.convertYouTubeEntryToPosteable(feedBean.getId(), entry));
            });
         }
      }
      return result;
   }

   private boolean checkIfEntryLinkIsRegistered(String link) throws TwitterPostException {
      try {
         return feedContentPostRepository.countByLink(link) > 0;
      } catch (Exception ex) {
         throw new TwitterPostException(ErrorCode.QUERY_SELECT_ERROR, ex, link);
      }
   }

   @Override
   public EntryContentPostedBean findEntryByMatch(TournamentBean tournamentBean, String homeTeam, String awayTeam) {
      return null;
   }

   @Override
   public void addNewFeed(FeedBean feedBean) throws TwitterPostException {

   }

   @Override
   public FeedBean editFeed(FeedBean feedBean) throws TwitterPostException {
      return null;
   }

   @Override
   public void addNewEntry(EntryContentPostedBean entryContentPostedBean) throws TwitterPostException {

   }

   @Override
   public void deleteEntryInTwitter(EntryContentPostedBean entryContentPostedBean) throws TwitterPostException {

   }

   @Override
   public List<EntryContentPostedBean> getLast10Entries(FeedBean feedBean) throws TwitterPostException {
      return null;
   }
}
