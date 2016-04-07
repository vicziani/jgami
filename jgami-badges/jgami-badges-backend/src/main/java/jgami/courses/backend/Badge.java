package jgami.courses.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Badge {

    @Id
    private UUID id;

    private String name;

    private String email;

    private long courseId;

    private LocalDateTime issuedAt;

    @Lob
    private byte[] png;

    private Badge() {
    }

    public Badge(String name, String email, long courseId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.courseId = courseId;
    }

    public void approve(byte[] png) {
        issuedAt = LocalDateTime.now();
        this.png = png;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getCourseId() {
        return courseId;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public byte[] getPng() {
        return png;
    }
}
