package jgami.badges.frontend;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BadgeRequestFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BadgeRequestForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BadgeRequestForm form = (BadgeRequestForm) target;
        ValidationUtils.rejectIfEmpty(errors, "email", "badges.validation.email.required");
        ValidationUtils.rejectIfEmpty(errors, "name", "badges.validation.name.required");
        if (form.getCourseId() == 0) {
            errors.rejectValue("courseId", "badges.validation.course.required");
        }
    }
}
