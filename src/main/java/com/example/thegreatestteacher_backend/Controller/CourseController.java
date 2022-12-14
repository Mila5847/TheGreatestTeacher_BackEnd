package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Entity.Score;
import com.example.thegreatestteacher_backend.Request.CourseRequest;
import com.example.thegreatestteacher_backend.Response.CourseResponse;
import com.example.thegreatestteacher_backend.Service.CourseService;
import com.example.thegreatestteacher_backend.Service.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    ScoreService scoreService;

    @GetMapping("/{teacherId}")
    public List<CourseResponse> getCoursesOfTeacher(@PathVariable int teacherId){
        List<Course> courses = courseService.getAllCoursesOfTeacher(teacherId);
        List<CourseResponse> coursesResponses = new ArrayList<>();
        for (Course course: courses) {
            Score score = scoreService.getScoreOfCourse(course.getId());
            int nbVotes = 0;
            if(score != null){
                nbVotes = score.getNumberVotes();
            }
            coursesResponses.add(new CourseResponse(course, nbVotes));
        }
        return coursesResponses;
    }

    @PostMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourseToTeacher(@PathVariable int teacherId, @RequestBody CourseRequest courseRequest){
        return new CourseResponse(courseService.addCourseToTeacher(teacherId, courseRequest));
    }

    @PutMapping("/{teacherId}/{courseId}")
    public CourseResponse updateCourse(@PathVariable int teacherId, @PathVariable int courseId, @Valid @RequestBody CourseRequest courseRequest){
        return new CourseResponse(courseService.updateCourse(teacherId, courseId, courseRequest));
    }
}
