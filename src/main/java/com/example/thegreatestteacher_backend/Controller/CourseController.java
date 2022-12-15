package com.example.thegreatestteacher_backend.Controller;


import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Request.CourseRequest;
import com.example.thegreatestteacher_backend.Response.CourseResponse;
import com.example.thegreatestteacher_backend.Service.CourseService;
import com.example.thegreatestteacher_backend.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/{teacherId}")
    public List<CourseResponse> getCoursesOfTeacher(@PathVariable int teacherId){
        List<Course> courses = courseService.getAllCoursesOfTeacher(teacherId);
        List<CourseResponse> coursesResponses = new ArrayList<>();
        for (Course course: courses) {
            coursesResponses.add(new CourseResponse(course));
        }
        return coursesResponses;
    }

    @PostMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourseToTeacher(@PathVariable int teacherId, @RequestBody CourseRequest courseRequest){
        return new CourseResponse(courseService.addCourseToTeacher(teacherId, courseRequest));
    }
}
