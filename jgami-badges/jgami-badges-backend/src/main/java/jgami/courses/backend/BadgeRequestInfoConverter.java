package jgami.courses.backend;

import jgami.courses.api.CourseInfo;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class BadgeRequestInfoConverter implements Converter<Badge, BadgeRequestInfo> {

    private Map<Long, CourseInfo> courses;

    public BadgeRequestInfoConverter(Map<Long, CourseInfo> courses) {
        this.courses = courses;
    }

    @Override
    public BadgeRequestInfo convert(Badge badge) {
        return new BadgeRequestInfo(badge.getId().toString(), badge.getName(), badge.getEmail(), courses.get(badge.getCourseId()).name);
    }
}
