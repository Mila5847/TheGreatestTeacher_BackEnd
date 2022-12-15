package com.example.thegreatestteacher_backend.Service;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Exception.ResourceNotFoundException;
import com.example.thegreatestteacher_backend.Repository.CourseRepository;
import com.example.thegreatestteacher_backend.Repository.TeacherRepository;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Request.CourseRequest;
import com.example.thegreatestteacher_backend.Request.TeacherRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Teacher> getAllTeachers(){
        return(List<Teacher>) teacherRepository.findAll();
    }

    public Teacher addTeachers(TeacherRequest teacherRequest) {
        Teacher teacher = new Teacher(teacherRequest);
        return teacherRepository.save(teacher);
    }
    public Course addCourseToTeacher(@PathVariable int teacherId, @Valid @RequestBody CourseRequest courseRequest) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("The teacher cannot be found."));
        Course courseToBeAdded = new Course(courseRequest);
        courseToBeAdded.setTeacher(teacher);
        return courseRepository.save(courseToBeAdded);
    }

    public List<Course> getAllCoursesForTeacher(@PathVariable int teacherId){
        return courseRepository.getAllByTeacherId(teacherId);
    }
}
