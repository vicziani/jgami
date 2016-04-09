package jgami.courses.backend;

import jgami.courses.api.CourseInfo;
import jgami.courses.api.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BadgeService {

    private BadgeRepository badgeRepository;

    private CourseInfoService courseInfoService;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository, CourseInfoService courseInfoService) {
        this.badgeRepository = badgeRepository;
        this.courseInfoService = courseInfoService;
    }

    public List<BadgeRequestInfo> listBadgeRequests() {
        BadgeRequestInfoConverter badgeRequestInfoConverter =
                new BadgeRequestInfoConverter(getCourses());

        return badgeRepository.findByIssuedAtIsNull().stream().map(
                b -> {return badgeRequestInfoConverter.convert(b);})
                .collect(Collectors.toList());
    }

    private Map<Long, CourseInfo> getCourses() {
        return courseInfoService.listCourses().stream().collect(
                Collectors.toMap(courseInfo -> {return courseInfo.id;}, Function.identity())
        );
    }

    public List<BadgeInfo> listBadges() {
        BadgeInfoConverter badgeInfoConverter = new BadgeInfoConverter(getCourses());

        return badgeRepository.findByIssuedAtIsNotNull().stream().map(
                b -> {return badgeInfoConverter.convert(b);})
                .collect(Collectors.toList());
    }

    public void requestBadge(BadgeRequest badgeRequest) {
        Badge badge = new Badge(badgeRequest.name,
                badgeRequest.email, badgeRequest.courseId);
        badgeRepository.save(badge);
    }

    @Transactional
    public void approveBadgeRequest(List<String> ids) {
        List<Badge> badges = badgeRepository.findAll(ids);
        badges.forEach(b -> {b.approve(null);});
    }

    public BadgeInfo getBadgeById(String id) {
        return new BadgeInfoConverter(getCourses()).convert(badgeRepository.findOne(id));
    }

    public List<CourseInfo> listCourses() {
        return courseInfoService.listCourses();
    }

}
