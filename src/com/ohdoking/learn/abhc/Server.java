package com.ohdoking.learn.abhc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
public @interface Server {


	public String value();

	public String description() default "";
	
	//Cookie
	//Authorization
	
	//여러개일 땐 {} 하나일 땐 ""
	public String[] headers() default "";
}
