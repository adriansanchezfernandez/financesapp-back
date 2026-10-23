package com.financesapp.financesapp_back.controller;

import com.financesapp.financesapp_back.model.Movement;
import com.financesapp.financesapp_back.service.MovementService;
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
    public Movement createMovement(@RequestBody Movement movement) {
        return movementService.createMovement(movement);
    }

}
