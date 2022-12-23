package com.example.thegreatestteacher_backend.Entity;

import com.example.thegreatestteacher_backend.Request.ScoreRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="scores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="numberVotes")
    public int numberVotes;

    @Column(name="totalScore")
    public double totalScore;

    @OneToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="fk_course_id")
    private Course course;

    public Score(Score score, ScoreRequest scoreRequest, Course course){
        id = score.getId();
        this.course = course;
        numberVotes = score.getNumberVotes() + 1;
        totalScore = score.getTotalScore() + scoreRequest.getScore();
    }

    public Score(ScoreRequest scoreRequest, Course course){
        id = scoreRequest.getId();
        this.course = course;
        numberVotes = 1;
        totalScore = scoreRequest.getScore();
    }
}
