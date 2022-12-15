package com.example.thegreatestteacher_backend.Response;

import com.example.thegreatestteacher_backend.Entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {
    private int id;
    private String fullName;

    public TeacherResponse(Teacher teacher){
        id = teacher.getId();
        fullName = teacher.getFirstName() + " " + teacher.getLastName();
    }
}
