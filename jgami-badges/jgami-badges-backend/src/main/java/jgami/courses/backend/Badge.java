package jgami.courses.backend;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "badges_badges")
public class Badge {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    private String name;

    private String email;

    @Column(name = "course_id")
    private long courseId;

    @Column(name = "issued_at", columnDefinition = "DATETIME")
    private LocalDateTime issuedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "badge_image_id")
    private BadgeImage badgeImage;

    private Badge() {
    }

    public Badge(String name, String email, long courseId) {
        this.name = name;
        this.email = email;
        this.courseId = courseId;
    }

    public void approve(byte[] png) {
        issuedAt = LocalDateTime.now();
        this.badgeImage = new BadgeImage(png);
    }

    public String getId() {
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

    public BadgeImage getBadgeImage() {
        return badgeImage;
    }
}
