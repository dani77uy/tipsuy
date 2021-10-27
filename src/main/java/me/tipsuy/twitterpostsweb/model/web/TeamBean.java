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
@Table(name = "TEAM", schema = "PUBLIC", catalog = "TIPSUY")
public class TeamBean extends BasicData {

   private String twitterAccount;

   private String instagramAccount;

   private String hashtag1;

   private String hashtag2;

   private String hashtag3;

   private Long countryId;

   private Boolean isNationalTeam;

   private CountryBean country;

   @Basic
   @Column(name = "TWITTER_ACCOUNT", nullable = true, length = 50)
   public String getTwitterAccount() {
      return twitterAccount;
   }

   public String showTwitterAccountWithAt(){
      return '@' + twitterAccount;
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
   @Column(name = "HASHTAG_1", nullable = false, length = 15)
   public String getHashtag1() {
      return hashtag1;
   }

   public void setHashtag1(String hashtag1) {
      this.hashtag1 = hashtag1;
   }

   @Basic
   @Column(name = "HASHTAG_2", nullable = true, length = 15)
   public String getHashtag2() {
      return hashtag2;
   }

   public void setHashtag2(String hashtag2) {
      this.hashtag2 = hashtag2;
   }

   @Basic
   @Column(name = "HASHTAG_3", nullable = true, length = 15)
   public String getHashtag3() {
      return hashtag3;
   }

   public void setHashtag3(String hashtag3) {
      this.hashtag3 = hashtag3;
   }

   @Basic
   @Column(name = "COUNTRY_ID", nullable = false)
   public Long getCountryId() {
      return countryId;
   }

   public void setCountryId(Long countryId) {
      this.countryId = countryId;
   }

   @Basic
   @Column(name = "IS_NATIONAL_TEAM", nullable = false)
   public Boolean getNationalTeam() {
      return isNationalTeam;
   }

   public void setNationalTeam(Boolean nationalTeam) {
      isNationalTeam = nationalTeam;
   }

   @Override
   public int hashCode() {
      var result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (twitterAccount != null ? twitterAccount.hashCode() : 0);
      result = 31 * result + (instagramAccount != null ? instagramAccount.hashCode() : 0);
      result = 31 * result + (hashtag1 != null ? hashtag1.hashCode() : 0);
      result = 31 * result + (hashtag2 != null ? hashtag2.hashCode() : 0);
      result = 31 * result + (hashtag3 != null ? hashtag3.hashCode() : 0);
      result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
      result = 31 * result + (isNationalTeam != null ? isNationalTeam.hashCode() : 0);
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

      final var teamBean = (TeamBean) o;

      if (!Objects.equals(id, teamBean.id)) {
         return false;
      }
      if (!Objects.equals(name, teamBean.name)) {
         return false;
      }
      if (!Objects.equals(twitterAccount, teamBean.twitterAccount)) {
         return false;
      }
      if (!Objects.equals(instagramAccount, teamBean.instagramAccount)) {
         return false;
      }
      if (!Objects.equals(hashtag1, teamBean.hashtag1)) {
         return false;
      }
      if (!Objects.equals(hashtag2, teamBean.hashtag2)) {
         return false;
      }
      if (!Objects.equals(hashtag3, teamBean.hashtag3)) {
         return false;
      }
      if (!Objects.equals(countryId, teamBean.countryId)) {
         return false;
      }
      return Objects.equals(isNationalTeam, teamBean.isNationalTeam);
   }

   @ManyToOne
   @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
   public CountryBean getCountry() {
      return country;
   }

   public void setCountry(CountryBean country) {
      this.country = country;
   }

   @Override
   public String generateHashtagsToString() {
      return "#" + hashtag1 + " #" + hashtag2 + " #" + hashtag3;
   }
}
