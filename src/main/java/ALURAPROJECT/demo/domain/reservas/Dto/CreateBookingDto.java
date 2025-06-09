package ALURAPROJECT.demo.domain.reservas.Dto;

import java.time.LocalDateTime;

import ALURAPROJECT.demo.domain.reservas.EnumBooking;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record CreateBookingDto(
    @NotNull
    Long userId,
    @NotNull
    Long chairId,
    @Future
    @NotNull
    LocalDateTime data_reserva,
    
    EnumBooking status) {

}
