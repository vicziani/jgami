package jgami.badges.frontend;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BadgeRequestFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BadgeRequestForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
