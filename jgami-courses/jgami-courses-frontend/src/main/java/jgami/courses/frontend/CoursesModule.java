package jgami.courses.frontend;

import jgami.core.MenuItem;
import jgami.core.Module;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CoursesModule implements Module {

    @Override
    public String getName() {
        return "Course";
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return Arrays.asList(new MenuItem("Kurzusok", "/admin/courses"));
    }
}
