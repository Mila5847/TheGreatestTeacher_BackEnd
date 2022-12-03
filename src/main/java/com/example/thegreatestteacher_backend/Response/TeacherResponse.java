package com.example.thegreatestteacher_backend.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeacherResponse {
    private int id;
    private String firstName;
    private String lastName;
}
