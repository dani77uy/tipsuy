package me.tipsuy.twitterpostsweb.model.web;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import me.tipsuy.twitterpostsweb.util.DatetimeUtil;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
@Entity
@Table(name = "ENTRY_CONTENT_POSTED", schema = "PUBLIC", catalog = "TIPSUY")
public class EntryContentPostedBean implements Serializable {

   private EntryContentPostedPK feedContentPostedPK;

   private Integer feedDateCreated;

   private Integer feedTimeCreated;

   private Integer feedDateEdited;

   private Integer feedTimeEdited;

   private FeedBean feed;

   private GregorianCalendar feedDatetimeRaised;

   @Basic
   @Column(name = "feed_date_created", nullable = false)
   public Integer getFeedDateCreated() {
      return feedDateCreated;
   }

   public void setFeedDateCreated(Integer feedDateCreated) {
      this.feedDateCreated = feedDateCreated;
   }

   @Basic
   @Column(name = "feed_time_created", nullable = false)
   public Integer getFeedTimeCreated() {
      return feedTimeCreated;
   }

   public void setFeedTimeCreated(Integer feedTimeCreated) {
      this.feedTimeCreated = feedTimeCreated;
   }

   @Basic
   @Column(name = "feed_date_edited")
   public Integer getFeedDateEdited() {
      return feedDateEdited;
   }

   public void setFeedDateEdited(Integer feedDateEdited) {
      this.feedDateEdited = feedDateEdited;
   }

   @Basic
   @Column(name = "feed_time_edited")
   public Integer getFeedTimeEdited() {
      return feedTimeEdited;
   }

   public void setFeedTimeEdited(Integer feedTimeEdited) {
      this.feedTimeEdited = feedTimeEdited;
   }

   @EmbeddedId
   public EntryContentPostedPK getFeedContentPostedPK() {
      return feedContentPostedPK;
   }

   public void setFeedContentPostedPK(EntryContentPostedPK feedContentPostedPK) {
      this.feedContentPostedPK = feedContentPostedPK;
   }

   @Basic
   @Column(name = "feed_datetime_raised", nullable = false)
   public GregorianCalendar getFeedDatetimeRaised() {
      return feedDatetimeRaised;
   }

   public void setFeedDatetimeRaised(GregorianCalendar feedDatetimeRaised) {
      this.feedDatetimeRaised = feedDatetimeRaised;
   }

   @ManyToOne
   @JoinColumn(name = "id_feed", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
   public FeedBean getFeed() {
      return feed;
   }

   public void setFeed(FeedBean feed) {
      this.feed = feed;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof EntryContentPostedBean)) {
         return false;
      }

      EntryContentPostedBean that = (EntryContentPostedBean) o;

      return getFeedContentPostedPK().equals(that.getFeedContentPostedPK());
   }

   @Override
   public int hashCode() {
      return getFeedContentPostedPK().hashCode();
   }

   @PrePersist
   void create() {
      this.feedDateCreated = DatetimeUtil.dateNow();
      this.feedTimeCreated = DatetimeUtil.timeNow();
   }

   @PreUpdate
   void update() {
      this.feedDateEdited = DatetimeUtil.dateNow();
      this.feedTimeEdited = DatetimeUtil.timeNow();
   }
}
