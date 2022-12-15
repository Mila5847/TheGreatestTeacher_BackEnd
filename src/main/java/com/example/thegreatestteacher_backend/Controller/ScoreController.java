package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Request.ScoreRequest;
import com.example.thegreatestteacher_backend.Response.ScoreResponse;
import com.example.thegreatestteacher_backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreResponse addScoreToCourse(@PathVariable int courseId, @RequestBody ScoreRequest scoreRequest){
        return new ScoreResponse(scoreService.addScoreToCourse(courseId, scoreRequest));
    }
}
