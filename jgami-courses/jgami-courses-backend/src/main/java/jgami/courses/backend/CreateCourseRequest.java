package jgami.courses.backend;

import java.time.LocalDate;

public class CreateCourseRequest {

    public final String name;

    public final String description;

    public final LocalDate start;

    public final LocalDate end;

    public CreateCourseRequest(String name, String description, LocalDate start, LocalDate end) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }
}
