package com.billing.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.billing.validator.annotation.impl.UserTypeValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy=UserTypeValidator.class)
@Target(FIELD)
public @interface UserType {

	String message() default "INVALID_USER_TYPE";
	
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
