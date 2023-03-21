package com.egor.spring.mvc_hibernate_aop.valiation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//инф о анотации сохр в плоть до выполнения кода
@Constraint(validatedBy=CheckEmailValidator.class)
public @interface CheckEmail {
    public String value() default "@gmail.com";
    public String message() default "email must ends with @gmail.com";
    public Class<?>[] groups() default {};//позволяет разбивать анотации по группам
    public Class<? extends Payload> [] payload() default {};//перенос информации о методанных клиента

}
