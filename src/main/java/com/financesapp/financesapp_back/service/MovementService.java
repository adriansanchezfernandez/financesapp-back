package com.financesapp.financesapp_back.service;

import com.financesapp.financesapp_back.dto.CreateMovementRequest;
import com.financesapp.financesapp_back.exception.MovementNotFoundException;
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

    public Movement createMovement(CreateMovementRequest request) {
        Movement movement = new Movement();

        movement.setDescripcion(request.descripcion());
        movement.setCantidad(request.cantidad());
        movement.setFecha(request.fecha());
        movement.setTipo(request.tipo());

        return movementRepository.save(movement);
    }

    public Movement getMovementById(Long id) {
        return movementRepository.findById(id)
                .orElseThrow(() -> new MovementNotFoundException(id));
    }

    public Movement updateMovement(Long id, CreateMovementRequest request) {

        Movement movement = getMovementById(id);

        movement.setDescripcion(request.descripcion());
        movement.setCantidad(request.cantidad());
        movement.setFecha(request.fecha());
        movement.setTipo(request.tipo());

        return movementRepository.save(movement);
    }

    public void deleteMovement(Long id) {

        Movement movement = getMovementById(id);

        movementRepository.delete(movement);
    }
}