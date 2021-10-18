package me.tipsuy.twitterpostsweb.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@Entity
@Table(name = "COUNTRY", schema = "PUBLIC", catalog = "TIPSUY")
public class CountryBean extends BasicData {

   private String alias;

   private String iso;

   private String hashtag;

   private Set<PlayerBean> playersByCountryId;

   private Set<TeamBean> teamsByCountryId;

   private Set<TournamentBean> tournamentsByCountryId;

   @Basic
   @Column(name = "ALIAS", nullable = false, length = 10)
   public String getAlias() {
      return alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   @Basic
   @Column(name = "ISO", nullable = true, length = 3)
   public String getIso() {
      return iso;
   }

   public void setIso(String iso) {
      this.iso = iso;
   }

   @Basic
   @Column(name = "HASHTAG", nullable = false, length = 15)
   public String getHashtag() {
      return hashtag;
   }

   public void setHashtag(String hashtag) {
      this.hashtag = hashtag;
   }

   @Override
   public int hashCode() {
      var result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (alias != null ? alias.hashCode() : 0);
      result = 31 * result + (iso != null ? iso.hashCode() : 0);
      result = 31 * result + (hashtag != null ? hashtag.hashCode() : 0);
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

      final var that = (CountryBean) o;

      if (!Objects.equals(id, that.id)) {
         return false;
      }
      if (!Objects.equals(name, that.name)) {
         return false;
      }
      if (!Objects.equals(alias, that.alias)) {
         return false;
      }
      if (!Objects.equals(iso, that.iso)) {
         return false;
      }
      return Objects.equals(hashtag, that.hashtag);
   }

   @OneToMany(mappedBy = "country")
   public Set<PlayerBean> getPlayersByCountryId() {
      return playersByCountryId;
   }

   public void setPlayersByCountryId(Set<PlayerBean> playersByCountryId) {
      this.playersByCountryId = playersByCountryId;
   }

   @OneToMany(mappedBy = "country")
   public Set<TeamBean> getTeamsByCountryId() {
      return teamsByCountryId;
   }

   public void setTeamsByCountryId(Set<TeamBean> teamsByCountryId) {
      this.teamsByCountryId = teamsByCountryId;
   }

   @OneToMany(mappedBy = "country")
   public Set<TournamentBean> getTournamentsByCountryId() {
      return tournamentsByCountryId;
   }

   public void setTournamentsByCountryId(Set<TournamentBean> tournamentsByCountryId) {
      this.tournamentsByCountryId = tournamentsByCountryId;
   }

   @Override
   public String generateHashtagsToString() {
      return "#" + hashtag;
   }
}
