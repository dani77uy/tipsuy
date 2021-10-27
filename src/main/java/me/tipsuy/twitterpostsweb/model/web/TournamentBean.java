package me.tipsuy.twitterpostsweb.model.web;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@Entity
@Table(name = "TOURNAMENT", schema = "PUBLIC", catalog = "TIPSUY")
public class TournamentBean extends BasicData {

   private String hashtag;

   private String twitterAccount;

   private String instagramAccount;

   private Boolean isInternational;

   private Long countryId;

   private CountryBean country;

   @Basic
   @Column(name = "HASHTAG", nullable = false, length = 15)
   public String getHashtag() {
      return hashtag;
   }

   public void setHashtag(String hashtag) {
      this.hashtag = hashtag;
   }

   @Basic
   @Column(name = "TWITTER_ACCOUNT", nullable = true, length = 50)
   public String getTwitterAccount() {
      return twitterAccount;
   }

   public void setTwitterAccount(String twitterAccount) {
      this.twitterAccount = twitterAccount;
   }

   @Basic
   @Column(name = "INSTAGRAM_ACCOUNT", nullable = true, length = 50)
   public String getInstagramAccount() {
      return instagramAccount;
   }

   public void setInstagramAccount(String instagramAccount) {
      this.instagramAccount = instagramAccount;
   }

   @Basic
   @Column(name = "IS_INTERNATIONAL", nullable = false)
   public Boolean getInternational() {
      return isInternational;
   }

   public void setInternational(Boolean international) {
      isInternational = international;
   }

   @Basic
   @Column(name = "COUNTRY_ID", nullable = true)
   public Long getCountryId() {
      return countryId;
   }

   public void setCountryId(Long countryId) {
      this.countryId = countryId;
   }

   @Override
   public int hashCode() {
      var result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (hashtag != null ? hashtag.hashCode() : 0);
      result = 31 * result + (twitterAccount != null ? twitterAccount.hashCode() : 0);
      result = 31 * result + (instagramAccount != null ? instagramAccount.hashCode() : 0);
      result = 31 * result + (isInternational != null ? isInternational.hashCode() : 0);
      result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
      return result;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      final var  that = (TournamentBean) o;

      if (!Objects.equals(id, that.id)) {
         return false;
      }
      if (!Objects.equals(name, that.name)) {
         return false;
      }
      if (!Objects.equals(hashtag, that.hashtag)) {
         return false;
      }
      if (!Objects.equals(twitterAccount, that.twitterAccount)) {
         return false;
      }
      if (!Objects.equals(instagramAccount, that.instagramAccount)) {
         return false;
      }
      if (!Objects.equals(isInternational, that.isInternational)) {
         return false;
      }
      return Objects.equals(countryId, that.countryId);
   }

   @ManyToOne
   @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", insertable = false, updatable = false)
   public CountryBean getCountry() {
      return country;
   }

   public void setCountry(CountryBean country) {
      this.country = country;
   }

   @Override
   public String generateHashtagsToString() {
      return "#" + hashtag;
   }
}
