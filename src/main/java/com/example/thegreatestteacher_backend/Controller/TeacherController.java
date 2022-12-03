package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Response.TeacherResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<TeacherResponse> getAllTeachers(){
        //List<Teacher> teachers =teacherService.getAllTeachers(firstName);
        List<TeacherResponse> teacherResponses= new ArrayList<TeacherResponse>();
        teacherResponses.add(new TeacherResponse(1, "Mila", "Kehayova"));
        teacherResponses.add(new TeacherResponse(2, "Petar", "Kehayov"));
        teacherResponses.add(new TeacherResponse(3, "Eli", "Kehayova"));

        return teacherResponses;
        //return "Hello";

    }
}
