package com.sravs.repo;

import com.sravs.entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepo extends JpaRepository<Interest,Integer> {
}
