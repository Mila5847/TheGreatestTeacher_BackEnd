package com.example.thegreatestteacher_backend.Response;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Entity.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreResponse {
    private int id;
    private int currentScore;

    private CourseResponse course;

    public ScoreResponse(Score score){
        id = score.getId();
        currentScore = score.getScore();
        course = new CourseResponse(score.getCourse());
    }
}
