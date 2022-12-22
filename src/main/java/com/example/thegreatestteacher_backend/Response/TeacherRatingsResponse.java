package com.example.thegreatestteacher_backend.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRatingsResponse {
    private int teacher_id;
    private String fullName;
    private double overallScore;
    private int overallNumberOfVotes;
}
