package com.personal.vamk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class TeacherController {

    @Autowired
    TeacherRepo repo;
    @GetMapping("/Teachers")
    public List<Teacher> getAll(){
        return repo.findAll();
    }
    @GetMapping("/Teacher/{id}")
    public Object teacher(@PathVariable String id){
        Optional<Teacher> find = repo.findById(id);
        Optional<Teacher> empty = Optional.empty();
        if(find.isPresent()) {
            return repo.findById(id);
        }else {
            return empty;
        }
    }
    @PostMapping("/Teacher")
    public Object newTeach(@RequestBody Teacher newTeach){
        return repo.save(newTeach);

    }
}
