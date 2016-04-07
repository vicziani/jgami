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
        ValidationUtils.rejectIfEmpty(errors, "name", "validation.name.required", "Name required!");
        ValidationUtils.rejectIfEmpty(errors, "description", "validation.name.required", "Description required!");
        ValidationUtils.rejectIfEmpty(errors, "start", "validation.name.required", "Start required!");
        ValidationUtils.rejectIfEmpty(errors, "end", "validation.name.required", "End required!");
    }
}
