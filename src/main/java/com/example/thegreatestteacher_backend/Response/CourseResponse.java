package com.example.thegreatestteacher_backend.Response;

import com.example.thegreatestteacher_backend.Entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private int id;
    private String name;

    private TeacherResponse teacher;

    public CourseResponse(Course course){
        id = course.getId();
        name = course.getName();
        teacher = new TeacherResponse(course.getTeacher());
    }
}
