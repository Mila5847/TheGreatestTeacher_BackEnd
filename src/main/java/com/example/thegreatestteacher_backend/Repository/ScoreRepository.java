package com.example.thegreatestteacher_backend.Repository;

import com.example.thegreatestteacher_backend.Entity.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Integer> {
    public Score getScoresByCourseId(int courseId);
    public Score getScoresByCourse_Id(int courseId);
}
