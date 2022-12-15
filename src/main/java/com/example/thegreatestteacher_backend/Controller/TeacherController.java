package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Request.CourseRequest;
import com.example.thegreatestteacher_backend.Request.ScoreRequest;
import com.example.thegreatestteacher_backend.Request.TeacherRequest;
import com.example.thegreatestteacher_backend.Response.CourseResponse;
import com.example.thegreatestteacher_backend.Response.ScoreResponse;
import com.example.thegreatestteacher_backend.Service.CourseService;
import com.example.thegreatestteacher_backend.Service.TeacherService;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Response.TeacherResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teachers")

public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @GetMapping()
    public List<TeacherResponse> getAllTeachers(){
        List<Teacher> teachers =teacherService.getAllTeachers();
        List<TeacherResponse> teacherResponses=new ArrayList<>();

        teachers.forEach(teacher->{
            TeacherResponse teacherResponse=new TeacherResponse(teacher);
            teacherResponses.add(teacherResponse);
        });

        return teacherResponses;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse addTeacher(@Valid @RequestBody TeacherRequest teacherRequest)
    {
        Teacher teacherToBeAdded = teacherService.addTeachers(teacherRequest);
        return new TeacherResponse(teacherToBeAdded);
    }

    @GetMapping("/{teacherId}/courses")
    public List<CourseResponse> getCoursesOfTeacher(@PathVariable int teacherId){
        List<Course> courses = teacherService.getAllCoursesForTeacher(teacherId);
        List<CourseResponse> coursesResponses = new ArrayList<>();
        for (Course course: courses) {
            coursesResponses.add(new CourseResponse(course));
        }
        return coursesResponses;
    }
    @PostMapping("/{teacherId}/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourseToTeacher(@PathVariable int teacherId, @RequestBody CourseRequest courseRequest){
        return new CourseResponse(teacherService.addCourseToTeacher(teacherId, courseRequest));
    }

    @PostMapping("/courses/{courseId}/scores")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreResponse addScoreToCourse(@PathVariable int courseId, @RequestBody ScoreRequest scoreRequest){
        return new ScoreResponse(courseService.addScoreToCourse(courseId, scoreRequest));
    }
}
