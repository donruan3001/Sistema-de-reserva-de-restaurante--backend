package ALURAPROJECT.demo.domain.reservas;

import java.time.LocalDateTime;

import ALURAPROJECT.demo.domain.User.User;
import ALURAPROJECT.demo.domain.mesas.Mesa;

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