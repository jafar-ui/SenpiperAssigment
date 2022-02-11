package com.example.liv2train.service;

import com.example.liv2train.entity.Course;
import com.example.liv2train.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo ;

    public Course add(Course course) {
        return courseRepo.save(course) ;
    }

    public List<Course> getAllCourse() throws Exception{
        return courseRepo.findAll();
    }

    public List<Course> addAll(List<Course> courses) {
        return courseRepo.saveAll(courses);
    }
}
