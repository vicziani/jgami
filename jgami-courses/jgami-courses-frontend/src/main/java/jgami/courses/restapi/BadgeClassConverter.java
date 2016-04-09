package jgami.courses.restapi;

import jgami.courses.api.CourseInfo;
import org.springframework.core.convert.converter.Converter;

public class BadgeClassConverter implements Converter<CourseInfo, BadgeClass> {

    private String path;

    public BadgeClassConverter(String path) {
        this.path = path;
    }

    @Override
    public BadgeClass convert(CourseInfo courseInfo) {
        BadgeClass badgeClass = new BadgeClass();
        badgeClass.setName(courseInfo.name);
        badgeClass.setDescription(courseInfo.description);
        badgeClass.setImage(path + "/images/course-badge.png");
        badgeClass.setCriteria(path + "/courses/" + courseInfo.id);
        badgeClass.setIssuer(path + "/api/organization");
        return badgeClass;
    }
}
