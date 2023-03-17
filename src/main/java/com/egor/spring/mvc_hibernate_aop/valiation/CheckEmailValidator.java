package com.egor.spring.mvc_hibernate_aop.valiation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail,String> {
    private String endOfEmail;



    @Override
    public void initialize(CheckEmail checkEmail) {
//за конец имейла в нашей анотации отечает метод value()
        endOfEmail=checkEmail.value();
    }

//Проверяем соответствует ли конец введеного значения endOfEmail
    @Override
    public boolean isValid
            (String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}
