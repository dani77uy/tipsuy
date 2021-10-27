package me.tipsuy.twitterpostsweb.util;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import me.tipsuy.twitterpostsweb.model.exception.TwitterPostException;

/**
 * @author Daniel Baharian
 * @since 24 oct. 2021
 */
public class UtilsError {

   public static void logError(Logger log, TwitterPostException ex) {
      log.error(printError(ex));
   }

   private static String printError(TwitterPostException ex) {
      final var sb = new StringBuilder();
      sb.append("Code: ").append(ex.getErrorCode().getErrorCode()).append("\n");
      sb.append("Message: ").append(ex.getErrorCode().getMessage()).append("\n");
      if (Objects.nonNull(ex.getParams())) {
         sb.append("Params: ").append(StringUtils.join(ex.getParams(), ",")).append("\n");
      }
      sb.append("================").append("\n");
      sb.append("Stack: ").append("\n\t");
      if (Objects.isNull(ex.getEx())) {
         sb.append(ex.getMessage());
      } else {
         sb.append(ex.getEx().getMessage());
      }
      return sb.toString();
   }
}
