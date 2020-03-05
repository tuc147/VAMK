package com.personal.vamk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepo repo;

    @GetMapping("/Teachers")
    public List<Teacher> getAll(){
        return repo.findAll();
    }

    @GetMapping("/Teachers/{id}")
    public Object teacher(@PathVariable String id){
        Optional<Teacher> find = repo.findById(id);
        Optional<Teacher> empty = Optional.empty();
        if(find.isPresent()) {
            return repo.findById(id);
        }else {
            return empty;
        }
    }
    @PostMapping("/Teachers")
    public Object newTeach(@RequestBody Teacher newTeach){
        return repo.save(newTeach);

    }
}
