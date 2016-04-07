package jgami.courses.api;

import java.util.List;

public interface CourseInfoService {

    List<CourseInfo> listCourses();

    CourseInfo findCourseById(long id);
}
