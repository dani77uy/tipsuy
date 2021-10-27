package me.tipsuy.twitterpostsweb.model.exception;

import lombok.Getter;

/**
 * @author Daniel Baharian
 * @since 24 oct. 2021
 */
@Getter
public enum ErrorCode {
   INVALID_TEAM(101, "Invalid team"),
   QUERY_SELECT_ERROR(1001, "Error retrieving data from database");

   private final int errorCode;
   private final String message;

   ErrorCode(int errorCode, String message) {
      this.errorCode = errorCode;
      this.message = message;
   }
}
