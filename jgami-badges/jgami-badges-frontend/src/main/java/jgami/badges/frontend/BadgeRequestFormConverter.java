package jgami.badges.frontend;

import jgami.courses.backend.BadgeRequest;
import org.springframework.core.convert.converter.Converter;

public class BadgeRequestFormConverter implements Converter<BadgeRequestForm, BadgeRequest> {

    @Override
    public BadgeRequest convert(BadgeRequestForm badgeRequestForm) {
        return new BadgeRequest(badgeRequestForm.getName(), badgeRequestForm.getEmail(), badgeRequestForm.getCourseId());
    }
}
