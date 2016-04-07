package jgami.courses.frontend;

import jgami.courses.backend.CreateCourseRequest;
import org.springframework.core.convert.converter.Converter;

public class CourseFormConverter implements Converter<CourseForm, CreateCourseRequest> {

    @Override
    public CreateCourseRequest convert(CourseForm courseForm) {
        return new CreateCourseRequest(courseForm.getName(), courseForm.getDescription(), courseForm.getStart(), courseForm.getEnd());
    }
}
