package ALURAPROJECT.demo.domain.reservas.Dto;

import java.time.LocalDateTime;

import ALURAPROJECT.demo.domain.reservas.EnumBooking;
import ALURAPROJECT.demo.domain.reservas.Reserva;


public record ListagemReservaDto(
    Long id,
    String nomeUsuario,
    String nomeMesa,
    LocalDateTime dataReserva,
    EnumBooking status
) {
    public ListagemReservaDto(Reserva reserva) {
        this(
            reserva.getId(),
            reserva.getUser().getNome(),
            reserva.getMesa().getNome(),
            reserva.getData_reserva(),
            reserva.getStatus()
        );
    }
} 