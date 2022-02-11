package com.example.liv2train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_centerDetails")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private Long id;

    private String CenterName;

    private Long CenterCode;
    private Long capacity;


    @OneToMany(targetEntity = Course.class)
    @JoinColumn(name = "tc_fk", referencedColumnName = "d_id")
    private List<Course> course;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @NonNull
    private String mail;

    @NonNull
    private Long contact;

}
