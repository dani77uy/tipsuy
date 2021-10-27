package me.tipsuy.twitterpostsweb.model.web;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
@Embeddable
public class EntryContentPostedPK implements Serializable {

   private Long idFeed;

   private String entryLinkId;

   /**
    * STATUS: <br>
    * 0 - Raised by service but not posted in twitter <br>
    * 1 - Raised by service and posted in twitter <br>
    * 2 - Raised by service and edited in twitter <br>
    * 3 - Raised by service and deleted in twitter <br>
    * 4 - Not used <br>
    * 5 - Not used <br>
    */
   private Integer status;

   @Column(name = "ID", nullable = false)
   public Long getIdFeed() {
      return idFeed;
   }

   public void setIdFeed(Long idFeed) {
      this.idFeed = idFeed;
   }

   @Column(name = "entry_link_id", nullable = false, length = 200)
   public String getEntryLinkId() {
      return entryLinkId;
   }

   public void setEntryLinkId(String entryLinkId) {
      this.entryLinkId = entryLinkId;
   }

   @Basic
   @Column(name = "status", nullable = false)
   @Min(0)
   @Max(5)
   public Integer getStatus() {
      return status;
   }

   public void setStatus(Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }

      if (!(o instanceof EntryContentPostedPK)) {
         return false;
      }

      EntryContentPostedPK that = (EntryContentPostedPK) o;

      return new EqualsBuilder()
            .append(getIdFeed(), that.getIdFeed())
            .append(getEntryLinkId(), that.getEntryLinkId())
            .append(getStatus(), that.getStatus())
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37).append(getIdFeed()).append(getEntryLinkId()).append(getStatus()).toHashCode();
   }
}
