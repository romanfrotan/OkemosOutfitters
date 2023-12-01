package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {IsInvValid.class})
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvRange {
    String message() default"Please enter a value that is in between the minimum inventory and maximum inventory value";
    Class<?> [] groups() default{};
    Class<? extends Payload> [] payload() default{};


}
