package jgami.courses.backend;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "courses_courses")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Column(columnDefinition = "DATE")
    private LocalDate start;

    @Column(columnDefinition = "DATE")
    private LocalDate end;

    private Course() {

    }

    public Course(String name, String description, LocalDate start, LocalDate end) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
