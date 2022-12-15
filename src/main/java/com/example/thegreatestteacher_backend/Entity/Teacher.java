package com.example.thegreatestteacher_backend.Entity;

import com.example.thegreatestteacher_backend.Request.TeacherRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;

    public Teacher(TeacherRequest teacherRequest){
        id = teacherRequest.getId();
        firstName = teacherRequest.getFirstName();
        lastName = teacherRequest.getLastName();
    }
}
