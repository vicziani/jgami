package jgami.courses.backend;

import jgami.courses.api.CourseInfo;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class BadgeInfoConverter implements Converter<Badge, BadgeInfo> {

    private Map<Long, CourseInfo> courses;

    public BadgeInfoConverter(Map<Long, CourseInfo> courses) {
        this.courses = courses;
    }

    @Override
    public BadgeInfo convert(Badge badge) {
        return new BadgeInfo(badge.getId(), badge.getName(), badge.getEmail(),
                courses.get(badge.getCourseId()).name, badge.getIssuedAt());
    }
}
