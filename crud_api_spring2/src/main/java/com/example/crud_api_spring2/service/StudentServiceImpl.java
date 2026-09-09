package com.example.crud_api_spring2.service;

import com.example.crud_api_spring2.Exception.StudentInfoNotFound;
import com.example.crud_api_spring2.dto.request.StudentRequest;
import com.example.crud_api_spring2.dto.response.StudentResponse;
import com.example.crud_api_spring2.entity.Student;
import com.example.crud_api_spring2.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getData() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentReponses = new ArrayList<>();
        for (Student student : students) {
            StudentResponse studentReponse = new StudentResponse();
            studentReponse.setId(student.getId());
            studentReponse.setName(student.getName());
            studentReponse.setGender(student.getGender());
            studentReponse.setEmail(student.getEmail());
            studentReponse.setAge(student.getAge());
            studentReponses.add(studentReponse);
        }
        return studentReponses;
    }

    @Override
    public StudentResponse create(StudentRequest studentRequest){
        Student student = new Student();
        student.setAge(studentRequest.getAge());
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setAge(student.getAge());
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setGender(student.getGender());
        return studentResponse;
    }

    @Override
    public void deleteData(Long id){
        Student stu1 = studentRepository.findById(id)
                .orElseThrow(() -> new StudentInfoNotFound("Information Not Found! PLease Check ID Again."));
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateData(Long id, StudentRequest studentRequest){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentInfoNotFound("Information Not Found! PLease Check ID Again."));


        student.setGender(studentRequest.getGender());
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        student=studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setAge(student.getAge());
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setGender(student.getGender());
        return studentResponse;
    }
}
