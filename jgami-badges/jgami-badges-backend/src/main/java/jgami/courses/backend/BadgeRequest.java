package jgami.courses.backend;

public class BadgeRequest {

    public final String name;

    public final String email;

    public final long courseId;

    public BadgeRequest(String name, String email, long courseId) {
        this.name = name;
        this.email = email;
        this.courseId = courseId;
    }
}
