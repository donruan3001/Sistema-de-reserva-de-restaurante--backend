package ALURAPROJECT.demo.domain.reservas;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record CreateBookingDto(
    @NotNull
    Long userId,
    @NotNull
    Long mesaId,
    @Future
    @NotNull
    LocalDateTime data_reserva,
    @NotNull
    EnumBooking status) {

}
