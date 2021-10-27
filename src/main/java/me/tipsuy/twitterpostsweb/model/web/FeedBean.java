package me.tipsuy.twitterpostsweb.model.web;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import me.tipsuy.twitterpostsweb.validation.FeedTypeParam;

/**
 * @author Daniel Baharian
 * @since 20 oct. 2021
 */
@Entity
@Table(name = "FEED", schema = "PUBLIC", catalog = "TIPSUY")
public class FeedBean implements Serializable {

   private Long id;

   private String channelName;

   private String channelURL;

   private String type;

   @Id
   @Column(name = "ID", nullable = false)
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Basic
   @Column(name = "channel_name", nullable = false, length = 20)
   public String getChannelName() {
      return channelName;
   }

   public void setChannelName(String channelName) {
      this.channelName = channelName;
   }

   @Basic
   @Column(name = "channel_url", nullable = false, length = 200)
   public String getChannelURL() {
      return channelURL;
   }

   public void setChannelURL(String channelURL) {
      this.channelURL = channelURL;
   }

   @Basic
   @Column(name = "type", nullable = false, length = 10)
   @FeedTypeParam
   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }

      if (!(o instanceof FeedBean)) {
         return false;
      }

      FeedBean feedBean = (FeedBean) o;

      return new EqualsBuilder()
            .append(getId(), feedBean.getId())
            .append(getChannelName(), feedBean.getChannelName())
            .append(getChannelURL(), feedBean.getChannelURL())
            .append(getType(), feedBean.getType())
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37).append(getId()).append(getChannelName()).append(getChannelURL()).append(getType()).toHashCode();
   }
}
