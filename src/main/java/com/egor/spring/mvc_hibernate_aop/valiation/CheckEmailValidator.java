package com.egor.spring.mvc_hibernate_aop.valiation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail,String> {
// ConstraintValidator<CheckEmail,String> CheckEmail-сама анотация, String-тип применяемых данных
    private String endOfEmail; //Переменная содержащая хвост email-а

    @Override
    public void initialize(CheckEmail checkEmail) {
//инициализируем конец email-а методом value()
        endOfEmail=checkEmail.value();
    }

//Проверяем соответствует ли конец введеного значения endOfEmail
    @Override
    public boolean isValid
            (String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}
