package com.example.crud_api_spring2.entity;


import com.example.crud_api_spring2.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    @Column(unique = true)
    private String email;
}
