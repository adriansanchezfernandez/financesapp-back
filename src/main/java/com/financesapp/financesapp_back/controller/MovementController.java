package com.financesapp.financesapp_back.controller;

import com.financesapp.financesapp_back.dto.CreateMovementRequest;
import com.financesapp.financesapp_back.model.Movement;
import com.financesapp.financesapp_back.service.MovementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovements();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movement createMovement(
            @Valid @RequestBody CreateMovementRequest request) {

        return movementService.createMovement(request);
    }
    @GetMapping("/{id}")
    public Movement getMovementById(@PathVariable Long id) {
        return movementService.getMovementById(id);
    }

    @PutMapping("/{id}")
    public Movement updateMovement(
            @PathVariable Long id,
            @Valid @RequestBody CreateMovementRequest request) {

        return movementService.updateMovement(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
    }
}
