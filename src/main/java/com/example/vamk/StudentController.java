package com.example.vamk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;

    @GetMapping("/Student")
    public List<Student> listAll(){
        return repo.findAll();
    }
    @GetMapping("/Student/{id}")
    public Optional<Student> student(@PathVariable String id){
        Optional<Student> findStudent = repo.findById(id);
        Optional<Student> empty = Optional.empty();

        if(!findStudent.isPresent()){

        }else{
            return findStudent;
        }
        return empty;
    }
    @PostMapping("/Students")
    public Object newStudent(@RequestBody Student newStu){

        if(newStu.getMajor()==null){
            newStu.setMajor("Undeclared");
        } else {
            return repo.save(newStu);
        }
        return repo.save(newStu);
    }
}
