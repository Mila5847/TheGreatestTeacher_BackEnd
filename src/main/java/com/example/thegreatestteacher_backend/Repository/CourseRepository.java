package com.example.thegreatestteacher_backend.Repository;

import com.example.thegreatestteacher_backend.Entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> getAllByTeacherId(int teacherId);
}
