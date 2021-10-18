package me.tipsuy.twitterpostsweb.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@MappedSuperclass
public abstract class BasicData implements Serializable {

   protected Long id;

   protected String name;

   @Id
   @Column(name = "ID", nullable = false)
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Basic
   @Column(name = "NAME", nullable = false, length = 50)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public abstract String generateHashtagsToString();
}
