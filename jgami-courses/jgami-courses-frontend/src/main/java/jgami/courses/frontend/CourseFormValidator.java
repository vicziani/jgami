package jgami.courses.frontend;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CourseFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "courses.validation.name.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "courses.validation.description.required");
        ValidationUtils.rejectIfEmpty(errors, "start", "courses.validation.start.required");
        ValidationUtils.rejectIfEmpty(errors, "end", "courses.validation.end.required");
    }
}
