package ALURAPROJECT.demo.domain.reservas.Dto;

import ALURAPROJECT.demo.domain.reservas.EnumBooking;
import jakarta.validation.constraints.NotNull;

public record UpdateReservaDto(
    @NotNull
    Long id,
    
    @NotNull
    EnumBooking status
) {} 