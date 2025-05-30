package ALURAPROJECT.demo.domain.reservas;

import jakarta.validation.constraints.NotNull;

public record UpdateReservaDto(
    @NotNull
    Long id,
    
    @NotNull
    EnumBooking status
) {} 