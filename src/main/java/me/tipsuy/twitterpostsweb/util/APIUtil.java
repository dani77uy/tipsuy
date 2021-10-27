package me.tipsuy.twitterpostsweb.util;

import me.tipsuy.twitterpostsweb.model.job.Feed;
import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedBean;
import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedPK;

/**
 * @author Daniel Baharian
 * @since 25 oct. 2021
 */
public class APIUtil {

   public static EntryContentPostedBean convertYouTubeEntryToPosteable(Long idFeed, Feed.Entry entry) {
      final var entryContentPostedBean = new EntryContentPostedBean();
      final var pk = new EntryContentPostedPK();
      pk.setEntryLinkId(entry.getId());
      pk.setIdFeed(idFeed);
      pk.setStatus(0);
      entryContentPostedBean.setFeedContentPostedPK(pk);
      entryContentPostedBean.setFeedDatetimeRaised(entry.getPublished().toGregorianCalendar());
      return entryContentPostedBean;
   }
}
