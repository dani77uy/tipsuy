package me.tipsuy.twitterpostsweb.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedBean;
import me.tipsuy.twitterpostsweb.model.web.EntryContentPostedPK;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
public interface FeedContentPostRepository extends PagingAndSortingRepository<EntryContentPostedBean, EntryContentPostedPK> {

   @Query("select fc from EntryContentPostedBean fc where fc.feedContentPostedPK.idFeed = ?1 and fc.feedContentPostedPK.status = ?2 order by fc.feedDateCreated desc, fc.feedTimeCreated desc")
   EntryContentPostedBean getLast(long feedId, boolean status);

   @Query("select count(o) from EntryContentPostedBean o where o.feedContentPostedPK.entryLinkId = ?1")
   long countByLink(String link);
}
