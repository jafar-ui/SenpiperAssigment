package com.example.liv2train.repo;

import com.example.liv2train.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course , Long> {
}
