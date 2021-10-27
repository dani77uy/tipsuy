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
@Table(name = "PLAYER", schema = "PUBLIC", catalog = "TIPSUY")
public class PlayerBean extends BasicData {

   private String alias;

   private String twitterAccount;

   private String instagramAccount;

   private Long nationalityId;

   private CountryBean country;

   @Basic
   @Column(name = "ALIAS", nullable = true, length = 30)
   public String getAlias() {
      return alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
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
   @Column(name = "NATIONALITY_ID", nullable = false)
   public Long getNationalityId() {
      return nationalityId;
   }

   public void setNationalityId(Long nationalityId) {
      this.nationalityId = nationalityId;
   }

   @Override
   public int hashCode() {
      var result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (alias != null ? alias.hashCode() : 0);
      result = 31 * result + (twitterAccount != null ? twitterAccount.hashCode() : 0);
      result = 31 * result + (instagramAccount != null ? instagramAccount.hashCode() : 0);
      result = 31 * result + (nationalityId != null ? nationalityId.hashCode() : 0);
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

      final var that = (PlayerBean) o;

      if (!Objects.equals(id, that.id)) {
         return false;
      }
      if (!Objects.equals(name, that.name)) {
         return false;
      }
      if (!Objects.equals(alias, that.alias)) {
         return false;
      }
      if (!Objects.equals(twitterAccount, that.twitterAccount)) {
         return false;
      }
      if (!Objects.equals(instagramAccount, that.instagramAccount)) {
         return false;
      }
      return Objects.equals(nationalityId, that.nationalityId);
   }

   @ManyToOne
   @JoinColumn(name = "NATIONALITY_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
   public CountryBean getCountry() {
      return country;
   }

   public void setCountry(CountryBean country) {
      this.country = country;
   }

   @Override
   public String generateHashtagsToString() {
      return "#" + alias;
   }
}
