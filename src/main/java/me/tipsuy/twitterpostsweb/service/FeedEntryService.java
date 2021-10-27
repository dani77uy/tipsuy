package me.tipsuy.twitterpostsweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import me.tipsuy.twitterpostsweb.model.exception.TwitterPostException;
import me.tipsuy.twitterpostsweb.model.job.Feed;
import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedBean;
import me.tipsuy.twitterpostsweb.model.web.FeedBean;
import me.tipsuy.twitterpostsweb.model.web.TournamentBean;

/**
 * @author Daniel Baharian
 * @since 25 oct. 2021
 */
@Service
public interface FeedEntryService {

   List<EntryContentPostedBean> checkNewEntryByFeed(FeedBean feedBean, Feed feed) throws TwitterPostException;

   EntryContentPostedBean findEntryByMatch(TournamentBean tournamentBean, String homeTeam, String awayTeam);

   void addNewFeed(FeedBean feedBean) throws TwitterPostException;

   FeedBean editFeed(FeedBean feedBean) throws TwitterPostException;

   void addNewEntry(EntryContentPostedBean entryContentPostedBean) throws TwitterPostException;

   void deleteEntryInTwitter(EntryContentPostedBean entryContentPostedBean) throws TwitterPostException;

   List<EntryContentPostedBean> getLast10Entries(FeedBean feedBean) throws TwitterPostException;
}
