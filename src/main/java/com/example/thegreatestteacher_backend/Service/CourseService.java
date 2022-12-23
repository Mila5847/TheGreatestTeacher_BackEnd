package com.example.thegreatestteacher_backend.Service;

import com.example.thegreatestteacher_backend.Entity.Course;
import com.example.thegreatestteacher_backend.Entity.Teacher;
import com.example.thegreatestteacher_backend.Exception.ResourceNotFoundException;
import com.example.thegreatestteacher_backend.Repository.CourseRepository;
import com.example.thegreatestteacher_backend.Repository.TeacherRepository;
import com.example.thegreatestteacher_backend.Request.CourseRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Course> getAllCoursesOfTeacher(@PathVariable int teacherId){
        return courseRepository.getAllByTeacherId(teacherId);
    }
    public Course addCourseToTeacher(@PathVariable int teacherId, @Valid @RequestBody CourseRequest courseRequest) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("The teacher cannot be found."));
        Course courseToBeAdded = new Course(courseRequest);
        courseToBeAdded.setTeacher(teacher);
        return courseRepository.save(courseToBeAdded);
    }

    public Course updateCourse(int teacherId, int courseId, CourseRequest courseRequest){
        if(!courseRepository.existsById(courseId)){
            throw new ResourceNotFoundException("The course cannot be found");
        }
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("The teacher cannot be found."));
        Course courseToBeUpdated = new Course(courseRequest, teacher);
        courseToBeUpdated.setId(courseId);
        return courseRepository.save(courseToBeUpdated);
    }
}
