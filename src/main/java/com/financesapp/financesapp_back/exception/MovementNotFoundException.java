package com.financesapp.financesapp_back.exception;

public class MovementNotFoundException extends RuntimeException {

    public MovementNotFoundException(Long id) {
        super("No existe un movimiento con ID " + id);
    }
}