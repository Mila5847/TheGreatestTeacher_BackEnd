package com.example.thegreatestteacher_backend.Controller;

import com.example.thegreatestteacher_backend.Request.TeacherRequest;
import com.example.thegreatestteacher_backend.Service.TeacherService;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Response.TeacherResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teachers")

public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping()
    public List<TeacherResponse> getAllTeachers(){
        List<Teacher> teachers =teacherService.getAllTeachers();
        List<TeacherResponse> teacherResponses=new ArrayList<>();

        teachers.forEach(teacher->{
            TeacherResponse teacherResponse=new TeacherResponse(teacher);
            teacherResponses.add(teacherResponse);
        });

        return teacherResponses;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse addTeacher(@Valid @RequestBody TeacherRequest teacherRequest)
    {
        Teacher teacherToBeAdded = teacherService.addTeachers(teacherRequest);
        return new TeacherResponse(teacherToBeAdded);
    }

    @DeleteMapping("/{teacherId}")
    public int deleteTeacher(@PathVariable int teacherId){
        return teacherService.deleteTeacher(teacherId);
    }
}
