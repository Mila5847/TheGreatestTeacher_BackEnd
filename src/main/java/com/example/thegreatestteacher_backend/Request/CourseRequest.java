package com.example.thegreatestteacher_backend.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    @NonNull
    private int id;
    @NotBlank
    private String name;
}
