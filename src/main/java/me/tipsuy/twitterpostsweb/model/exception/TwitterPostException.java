package me.tipsuy.twitterpostsweb.model.exception;

import java.io.Serializable;

import lombok.Getter;

/**
 * @author Daniel Baharian
 * @since 24 oct. 2021
 */
@Getter
public class TwitterPostException extends Exception {

   private final ErrorCode errorCode;

   private final Serializable[] params;

   private final Exception ex;

   public TwitterPostException(ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.errorCode = errorCode;
      this.params = null;
      this.ex = null;
   }

   public TwitterPostException(ErrorCode errorCode, Exception ex, Serializable... params) {
      super(ex);
      this.ex = ex;
      this.errorCode = errorCode;
      this.params = params;
   }

}
