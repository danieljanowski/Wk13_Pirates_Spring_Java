package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirates_Raids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pirates_RaidsRepository extends JpaRepository <Pirates_Raids, Long> {
}
