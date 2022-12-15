package com.example.thegreatestteacher_backend.Entity;

import com.example.thegreatestteacher_backend.Request.CourseRequest;
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

    @Column(name="score")
    public int score;
    @Column(name="numberVotes")
    public int numberVotes;

    @Column(name="totalScore")
    public int totalScore;

    @OneToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="fk_course_id")
    private Course course;

    public Score(ScoreRequest scoreRequest){
        id = scoreRequest.getId();
        score = scoreRequest.getScore();
        /*numberVotes = scoreRequest.getNumberVotes();
        totalScore = scoreRequest.getTotalScore();*/
    }
}
