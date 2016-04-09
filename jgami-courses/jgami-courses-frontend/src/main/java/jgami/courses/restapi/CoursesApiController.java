package jgami.courses.restapi;

import jgami.courses.backend.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoursesApiController {

    private CourseService courseService;

    @Value("${badges.host}")
    private String path;

    @Autowired
    public CoursesApiController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/badgeclass/{id}")
    public BadgeClass badgeClass(@PathVariable long id) {
        return new BadgeClassConverter(path).convert(courseService.findCourseById(id));
    }

    @RequestMapping("/organization")
    public Organization organization() {
        return new Organization("JTechLog", path + "/images/jtechlog.png", path, "viczian.istvan@gmail.com");
    }
}
