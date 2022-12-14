package com.example.thegreatestteacher_backend.Service;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Entity.Score;
import com.example.thegreatestteacher_backend.Exception.ResourceNotFoundException;
import com.example.thegreatestteacher_backend.Repository.CourseRepository;
import com.example.thegreatestteacher_backend.Repository.ScoreRepository;
import com.example.thegreatestteacher_backend.Request.ScoreRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    CourseRepository courseRepository;
    public Score addScoreToCourse(@PathVariable int courseId, @Valid @RequestBody ScoreRequest scoreRequest) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("The course cannot be found."));

        Score score = scoreRepository.getScoresByCourseId(courseId);
        if(score == null){
            Score scoreToAdd = new Score(scoreRequest, course);
            return scoreRepository.save(scoreToAdd);
        }
        Score scoreToBeAdded = new Score(score, scoreRequest, course);
        return scoreRepository.save(scoreToBeAdded);
    }

    public Score getScoreOfCourse(int course_id){
        return scoreRepository.getScoresByCourseId(course_id);
    }
}
