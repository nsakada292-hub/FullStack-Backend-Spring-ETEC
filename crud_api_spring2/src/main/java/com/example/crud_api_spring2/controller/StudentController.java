package com.example.crud_api_spring2.controller;

import com.example.crud_api_spring2.Exception.StudentInfoNotFound;
import com.example.crud_api_spring2.dto.request.StudentRequest;
import com.example.crud_api_spring2.dto.response.StudentResponse;
import com.example.crud_api_spring2.entity.Student;
import com.example.crud_api_spring2.repository.StudentRepository;
import com.example.crud_api_spring2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")  // this is call RESTapi
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @GetMapping
    public List<StudentResponse> getData(){
        return studentService.getData();
    }
    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest studentRequest){
        return studentService.create(studentRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id){
        studentService.deleteData(id);
    }
    @PutMapping("/{id}")
    public StudentResponse updateData(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateData(id, studentRequest);
    }
}
