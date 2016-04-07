package jgami.courses.api;

import java.time.LocalDate;

public class CourseInfo {

    public final Long id;

    public final String name;

    public final String description;

    public final LocalDate start;

    public final LocalDate end;

    public CourseInfo(Long id, String name, String description, LocalDate start, LocalDate end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }
}
