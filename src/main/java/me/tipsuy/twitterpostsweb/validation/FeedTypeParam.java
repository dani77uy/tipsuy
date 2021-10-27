package me.tipsuy.twitterpostsweb.validation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Daniel Baharian
 * @since 23 oct. 2021
 */
@Constraint(validatedBy = FeedTypeValidator.class)
@Target({ METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface FeedTypeParam {

   String message() default
         "Invalid Feed Type";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
