package com.personal.vamk;

import org.springframework.data.annotation.Id;


import java.util.List;

public class Course {
    @Id
    private String id;
    private String name;
    private Teacher teacher;
    private List<Student> roster;
    private List<Assignment> work;

    public Course() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getRoster() {
        return roster;
    }

    public void setRoster(List<Student> roster) {
        this.roster = roster;
    }

    public List<Assignment> getWork() {
        return work;
    }

    public void setWork(List<Assignment> work) {
        this.work = work;
    }
}
