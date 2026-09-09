package com.example.crud_api_teacher.Controller;

import com.example.crud_api_teacher.Entity.Teacher;
import com.example.crud_api_teacher.Exception.TeacherInfoNotFound;
import com.example.crud_api_teacher.Repositpry.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    public TeacherRepository teacherRepository;

//    Create
    @PostMapping("/createData")
    public Teacher createData(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

//    Read
    @GetMapping("/readData")
    public List<Teacher> readData(){
        return teacherRepository.findAll();
    }

//    Delete
    @DeleteMapping("/deleteData/{id}")
    public void deleteData(@PathVariable Long id){
        teacherRepository.deleteById(id);
    }

//   Update
    @PutMapping("/update/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher t1 = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherInfoNotFound("Teacher Information not found"));
        // orElseThrow use for catch error and we need to write like that
        // orElseThrow also should use in delete, it will better

        t1.setAge(teacher.getAge()); // set line 37 hx yg get tv oy line 36, set to update, get to show data
        t1.setEmail(teacher.getEmail());
        t1.setGender(teacher.getGender());
        t1.setSalary(teacher.getSalary());
        t1.setTeacherName(teacher.getTeacherName());
        t1.setPhoneNumber(teacher.getPhoneNumber());
        t1.setSubject(teacher.getSubject());

        return teacherRepository.save(t1);
    }
}
