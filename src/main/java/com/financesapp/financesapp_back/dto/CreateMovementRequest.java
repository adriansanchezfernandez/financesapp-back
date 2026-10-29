package com.financesapp.financesapp_back.dto;


import com.financesapp.financesapp_back.model.MovementType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateMovementRequest(
        @NotBlank(message = "La descripción es obligatoria")
        String descripcion,


        @NotNull(message = "La cantidad es obligatoria")
        @DecimalMin(
                value = "0.01",
                message = "La cantidad debe ser mayor que cero"
        )
        BigDecimal cantidad,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fecha,

        @NotNull(message = "El tipo es obligatorio")
        MovementType tipo
) {}