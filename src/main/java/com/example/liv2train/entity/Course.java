package com.example.liv2train.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    private Long id ;
    private String courseName ;

}
