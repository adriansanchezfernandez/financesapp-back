package com.financesapp.financesapp_back.repository;

import com.financesapp.financesapp_back.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}