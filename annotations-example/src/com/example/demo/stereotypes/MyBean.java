package com.example.demo.stereotypes;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
//@Target(TYPE)
@Target({TYPE,METHOD})


public @interface MyBean {

	String name();
	String scope() default "singleton";
}
