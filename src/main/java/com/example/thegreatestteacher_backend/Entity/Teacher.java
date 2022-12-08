package com.example.thegreatestteacher_backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
}
