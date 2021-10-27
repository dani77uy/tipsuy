package me.tipsuy.twitterpostsweb.model.web;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vdurmont.emoji.EmojiManager;

import me.tipsuy.twitterpostsweb.util.CharacterUtil;
import me.tipsuy.twitterpostsweb.util.DatetimeUtil;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@Entity
@Table(name = "TWITTER_POST", schema = "PUBLIC", catalog = "TIPSUY")
public class TwitterPostBean implements Serializable {

   private Long id;

   private Long homeTeamId;

   private Long awayTeamId;

   private Short goalsHome;

   private Short goalsAway;

   private Integer startDate;

   private Integer startTime;

   private String timezone;

   private String venue;

   private Short style;

   private TournamentBean tournament;

   private TeamBean homeTeam;

   private TeamBean awayTeam;

   @Id
   @Column(name = "ID", nullable = false)
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Basic
   @Column(name = "HOME_TEAM", nullable = false)
   public Long getHomeTeamId() {
      return homeTeamId;
   }

   public void setHomeTeamId(Long homeTeamId) {
      this.homeTeamId = homeTeamId;
   }

   @Basic
   @Column(name = "AWAY_TEAM", nullable = false)
   public Long getAwayTeamId() {
      return awayTeamId;
   }

   public void setAwayTeamId(Long awayTeamId) {
      this.awayTeamId = awayTeamId;
   }

   @Basic
   @Column(name = "GOALS_HOME", nullable = true)
   public Short getGoalsHome() {
      return goalsHome;
   }

   public void setGoalsHome(Short goalsHome) {
      this.goalsHome = goalsHome;
   }

   @Basic
   @Column(name = "GOALS_AWAY", nullable = true)
   public Short getGoalsAway() {
      return goalsAway;
   }

   public void setGoalsAway(Short goalsAway) {
      this.goalsAway = goalsAway;
   }

   @Basic
   @Column(name = "START_DATE", nullable = false)
   public Integer getStartDate() {
      return startDate;
   }

   public void setStartDate(Integer startDate) {
      this.startDate = startDate;
   }

   @Basic
   @Column(name = "START_TIME", nullable = false)
   public Integer getStartTime() {
      return startTime;
   }

   public void setStartTime(Integer startTime) {
      this.startTime = startTime;
   }

   @Basic
   @Column(name = "TIMEZONE", nullable = true, length = 10)
   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   @Basic
   @Column(name = "VENUE", nullable = true, length = 60)
   public String getVenue() {
      return venue;
   }

   public void setVenue(String venue) {
      this.venue = venue;
   }

   @Basic
   @Column(name = "STYLE", nullable = true)
   public Short getStyle() {
      return style;
   }

   public void setStyle(Short style) {
      this.style = style;
   }

   @Override
   public int hashCode() {
      var result = id != null ? id.hashCode() : 0;
      result = 31 * result + (homeTeamId != null ? homeTeamId.hashCode() : 0);
      result = 31 * result + (awayTeamId != null ? awayTeamId.hashCode() : 0);
      result = 31 * result + (goalsHome != null ? goalsHome.hashCode() : 0);
      result = 31 * result + (goalsAway != null ? goalsAway.hashCode() : 0);
      result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
      result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
      result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
      result = 31 * result + (venue != null ? venue.hashCode() : 0);
      result = 31 * result + (style != null ? style.hashCode() : 0);
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

      final var that = (TwitterPostBean) o;

      if (!Objects.equals(id, that.id)) {
         return false;
      }
      if (!Objects.equals(homeTeamId, that.homeTeamId)) {
         return false;
      }
      if (!Objects.equals(awayTeamId, that.awayTeamId)) {
         return false;
      }
      if (!Objects.equals(goalsHome, that.goalsHome)) {
         return false;
      }
      if (!Objects.equals(goalsAway, that.goalsAway)) {
         return false;
      }
      if (!Objects.equals(startDate, that.startDate)) {
         return false;
      }
      if (!Objects.equals(startTime, that.startTime)) {
         return false;
      }
      if (!Objects.equals(timezone, that.timezone)) {
         return false;
      }
      if (!Objects.equals(venue, that.venue)) {
         return false;
      }
      return Objects.equals(style, that.style);
   }

   @ManyToOne
   @JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
   public TournamentBean getTournament() {
      return tournament;
   }

   public void setTournament(TournamentBean tournament) {
      this.tournament = tournament;
   }

   @ManyToOne
   @JoinColumn(name = "HOME_TEAM", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
   public TeamBean getHomeTeam() {
      return homeTeam;
   }

   public void setHomeTeam(TeamBean homeTeam) {
      this.homeTeam = homeTeam;
   }

   @ManyToOne
   @JoinColumn(name = "AWAY_TEAM", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
   public TeamBean getAwayTeam() {
      return awayTeam;
   }

   public void setAwayTeam(TeamBean awayTeam) {
      this.awayTeam = awayTeam;
   }

   public String generatePreMatchPost() {
      final var result = new StringBuilder();
      result.append(CharacterUtil.convertWordToStyle(style, homeTeam.getName()));
      result.append(" ").append(EmojiManager.getForTag("vs"));
      result.append(" ").append(CharacterUtil.convertWordToStyle(style, awayTeam.getName())).append("\n");
      result.append(EmojiManager.getForAlias("award")).append(" ").append(tournament.getName())
            .append(" ").append(CharacterUtil.getCountryEmojiFlag(tournament.getCountry().getAlias())).append("\n");
      final var date = DatetimeUtil.convertDateToString(startDate, '/');
      final var time = DatetimeUtil.convertTimeToString(startTime);
      result.append(EmojiManager.getForAlias("schedule")).append(" ").append(date).append("\n");
      result.append(EmojiManager.getForAlias("time")).append(" ").append(time).append("\n");
      result.append(EmojiManager.getForTag("stadium")).append(" ").append(venue).append("\n");
      result.append(homeTeam.generateHashtagsToString()).append(" ").append(awayTeam.generateHashtagsToString());
      return result.toString();
   }

   public String generatePostWithResult() {
      final var result = new StringBuilder();
      result.append(homeTeam.getTwitterAccount());
      result.append(" ").append(CharacterUtil.getNumberEmoji(goalsHome)).append(" ").append(CharacterUtil.getNumberEmoji(goalsAway)).append("\n");
      result.append(tournament.getTwitterAccount()).append("\n");
      result.append(homeTeam.generateHashtagsToString()).append(" ").append(awayTeam.generateHashtagsToString());
      return result.toString();
   }
}
