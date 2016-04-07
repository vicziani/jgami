package jgami.courses.backend;

import java.time.LocalDateTime;
import java.util.UUID;

public class BadgeInfo {

    public final UUID id;

    public final String name;

    public final String email;

    public final String courseName;

    public final LocalDateTime issuedAt;

    public BadgeInfo(UUID id, String name, String email, String courseName, LocalDateTime issuedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseName = courseName;
        this.issuedAt = issuedAt;
    }
}
