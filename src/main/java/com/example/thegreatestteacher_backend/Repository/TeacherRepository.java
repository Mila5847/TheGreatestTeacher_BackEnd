package com.example.thegreatestteacher_backend.Repository;

import com.example.thegreatestteacher_backend.Entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
