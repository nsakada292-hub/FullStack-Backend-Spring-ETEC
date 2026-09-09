package com.example.crud_api_spring2.dto.request;

import com.example.crud_api_spring2.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class StudentRequest {
    private String name;
    private Gender gender;
    private Integer age;
    private String email;
}
