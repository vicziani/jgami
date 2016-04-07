package jgami.courses.backend;

public class BadgeRequestInfo {

    public final String id;

    public final String name;

    public final String email;

    public final String courseName;

    public BadgeRequestInfo(String id, String name, String email, String courseName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseName = courseName;
    }
}
