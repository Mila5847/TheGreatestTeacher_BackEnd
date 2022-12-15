package com.example.thegreatestteacher_backend.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreRequest {
    @NotNull
    private int id;
    @NotNull
    private int score;
    /*@NotNull
    public int numberVotes;
    @NotNull
    public int totalScore;*/
}
