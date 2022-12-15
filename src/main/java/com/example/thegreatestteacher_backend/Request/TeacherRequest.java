package com.example.thegreatestteacher_backend.Request;

import com.example.thegreatestteacher_backend.Entity.Teacher;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
@Getter
@Setter
public class TeacherRequest {
    @NonNull
    private int id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
