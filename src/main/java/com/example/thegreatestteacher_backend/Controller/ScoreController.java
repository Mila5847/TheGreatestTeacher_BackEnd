package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Entity.Score;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Request.ScoreRequest;
import com.example.thegreatestteacher_backend.Response.ScoreResponse;
import com.example.thegreatestteacher_backend.Response.TeacherRatingsResponse;
import com.example.thegreatestteacher_backend.Service.CourseService;
import com.example.thegreatestteacher_backend.Service.ScoreService;
import com.example.thegreatestteacher_backend.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @PostMapping("/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreResponse addScoreToCourse(@PathVariable int courseId, @RequestBody ScoreRequest scoreRequest){
        return new ScoreResponse(scoreService.addScoreToCourse(courseId, scoreRequest));
    }

    @GetMapping()
    public List<TeacherRatingsResponse> getScoresForAllTeachers(){
        List<TeacherRatingsResponse> teacherRatingsResponsesList = new ArrayList<>();
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        for (Teacher teacher: allTeachers) {
            List<Course> courses = courseService.getAllCoursesOfTeacher(teacher.getId());
            double overAllTotal = 0;
            int overallNumberOfVotes = 0;
            for (Course course: courses) {
                Score score = scoreService.getScoreOfCourse(course.getId());
                if(score == null){
                    continue;
                }
                overAllTotal += score.getTotalScore();
                overallNumberOfVotes += score.getNumberVotes();
            }
            String fullName = teacher.getFirstName() + " " + teacher.getLastName();
            double overallScore = 0;
            if(overallNumberOfVotes == 0){
                overallScore = 0;
            }
            else{
                overallScore = overAllTotal / overallNumberOfVotes;
            }
            TeacherRatingsResponse teacherRatingsResponse = new TeacherRatingsResponse(teacher.getId(), fullName, overallScore, overallNumberOfVotes);
            teacherRatingsResponsesList.add(teacherRatingsResponse);
        }
        return teacherRatingsResponsesList;
    }
}
