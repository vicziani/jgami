package jgami.courses.backend;

import java.time.LocalDateTime;

public class BadgeInfo {

    public final String id;

    public final String name;

    public final String email;

    public final long courseId;

    public final String courseName;

    public final LocalDateTime issuedAt;

    public BadgeInfo(String id, String name, String email, long courseId, String courseName, LocalDateTime issuedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseId = courseId;
        this.courseName = courseName;
        this.issuedAt = issuedAt;
    }
}
