package jgami.courses.frontend;

import jgami.courses.api.CourseInfoService;
import jgami.courses.backend.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoursesController {

    private CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @InitBinder("courseForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new CourseFormValidator());
    }

    @RequestMapping(value = "/admin/courses", method = RequestMethod.GET)
    public ModelAndView listCourses() {
        return new ModelAndView("courses")
                .addObject("courses", courseService.listCourses())
                .addObject("courseForm", new CourseForm());
    }

    @RequestMapping(value = "/admin/courses", method = RequestMethod.POST)
    public ModelAndView saveCourse(
            @Validated CourseForm courseForm, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("courses", "courses", courseService.listCourses());
        }

        courseService.createCourse(new CourseFormConverter().convert(courseForm));
        redirectAttributes.addFlashAttribute("message", "courses.message.successfull.course.save");
        return new ModelAndView("redirect:/admin/courses");
    }

}
