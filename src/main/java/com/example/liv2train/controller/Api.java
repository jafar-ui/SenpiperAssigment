package com.example.liv2train.controller;

import com.example.liv2train.entity.Course;
import com.example.liv2train.entity.TrainingCenter;
import com.example.liv2train.service.CenterService;
import com.example.liv2train.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Api {

    @Autowired
    private CenterService service;

    @Autowired
    private CourseService courseService;

    @PostMapping("/add/center")
    public ResponseEntity<?> register(@RequestBody TrainingCenter center) throws Exception {
        try {
            return new ResponseEntity(service.addCenter(center), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }


    @PostMapping("/add/course")
    public ResponseEntity<?> registerCourse(@RequestBody Course course) throws Exception {
        try {

            return new ResponseEntity(courseService.add(course), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/get/all/training")
    public ResponseEntity<?> getAllCenter() throws Exception {
        try {
            return new ResponseEntity(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/allCourse")
    public ResponseEntity<?> getAllCourse() throws Exception {
        try {
            return new ResponseEntity(courseService.getAllCourse(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/add/all/course")
    public ResponseEntity<?> addAllCourse(@RequestBody List<Course> courses) throws Exception {
        try {
            return new ResponseEntity(courseService.addAll(courses), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

}
