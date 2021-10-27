package me.tipsuy.twitterpostsweb.validation;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
public class FeedTypeValidator implements ConstraintValidator<FeedTypeParam, String> {

   public static final String INSTAGRAM = "INSTAGRAM";
   public static final String YOUTUBE = "YOUTUBE";
   public static final String TWITTER = "TWITTER";
   public static final String RSS = "RSS";

   @Override
   public void initialize(FeedTypeParam constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      if (StringUtils.isEmpty(value)) {
         return false;
      }
      final var val = value.toUpperCase(Locale.ROOT);
      switch (val) {
         case INSTAGRAM:
         case YOUTUBE:
         case TWITTER:
         case RSS:
            return true;
         default:
            return false;
      }
   }
}
