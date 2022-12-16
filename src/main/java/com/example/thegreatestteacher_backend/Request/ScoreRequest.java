package com.example.thegreatestteacher_backend.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ScoreRequest {
    @NonNull
    private int id;
    @NonNull
    private double score;
}
