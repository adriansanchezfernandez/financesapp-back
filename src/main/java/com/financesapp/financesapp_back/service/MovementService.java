package com.financesapp.financesapp_back.service;

import com.financesapp.financesapp_back.model.Movement;
import com.financesapp.financesapp_back.repository.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    public Movement createMovement(Movement movement) {
        return movementRepository.save(movement);
    }

}