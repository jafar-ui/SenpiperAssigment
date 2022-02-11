package com.example.liv2train.repo;

import com.example.liv2train.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface TrainingCenterRepo extends JpaRepository<TrainingCenter , Long> {
}
