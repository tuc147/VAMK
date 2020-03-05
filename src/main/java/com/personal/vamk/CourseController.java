package com.personal.vamk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepo Trepo;
    @Autowired
    StudentRepo Srepo;

    @GetMapping("/Courses")
    public List<Course> getAll(){
        return Trepo.findAll();
    }
    @GetMapping("/Courses/{id}")
    public Object find(@PathVariable String id){
        Optional<Course> find = Trepo.findById(id);
        Optional<Course> empty = Optional.empty();

        if(find.isPresent()){
            return Trepo.findById(id);
        }else{
            return empty;
        }

    }
    @PostMapping("/Courses")
    public Object newCourse(@RequestBody Course newCourse){
        return Trepo.save(newCourse);
    }
    @PutMapping("/Course/{id}")
    public Object addStudent(@RequestBody Student student, @PathVariable String id){
        Optional<Course> editCourse = Trepo.findById(id);
        Optional<Course> empty = Optional.empty();
        if(Srepo.findById(student.getId()).isPresent()){

        }else{
            Srepo.save(student);
        }
        if(editCourse.isPresent()){
            Trepo.findById(id).get().getRoster().add(student);
            return Trepo.findById(id);

        }else{
            return empty;
        }
    }
}
