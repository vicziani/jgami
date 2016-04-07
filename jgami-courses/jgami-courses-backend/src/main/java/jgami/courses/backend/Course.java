package jgami.courses.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate start;

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
