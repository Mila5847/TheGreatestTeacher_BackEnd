package com.example.thegreatestteacher_backend.Service;

import com.example.thegreatestteacher_backend.Repository.CourseRepository;
import com.example.thegreatestteacher_backend.Repository.TeacherRepository;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Request.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public int deleteTeacher(int teacherId){
        teacherRepository.deleteById(teacherId);
        return teacherId;
    }
}
