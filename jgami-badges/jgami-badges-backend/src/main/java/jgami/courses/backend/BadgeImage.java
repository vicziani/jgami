package jgami.courses.backend;

import javax.persistence.*;

@Entity
@Table(name = "badges_badge_images")
public class BadgeImage {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] png;

    public BadgeImage() {
    }

    public BadgeImage(byte[] png) {
        this.png = png;
    }

    public Long getId() {
        return id;
    }

    public byte[] getPng() {
        return png;
    }
}
