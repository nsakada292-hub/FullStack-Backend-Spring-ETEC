package com.example.crud_api_spring2.service;

import com.example.crud_api_spring2.dto.request.StudentRequest;
import com.example.crud_api_spring2.dto.response.StudentResponse;
import com.example.crud_api_spring2.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getData();
    StudentResponse create(StudentRequest studentRequest);
    void deleteData(Long id);
    StudentResponse updateData(Long id, StudentRequest studentRequest);
}
