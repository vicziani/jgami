package jgami.courses.frontend;

import jgami.courses.backend.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/courses/{id}")
    public ModelAndView course(@PathVariable long id) {
        return new ModelAndView("course", "course", courseService.findCourseById(id));
    }
}
