package ALURAPROJECT.demo.domain.reservas.Dto;

import java.time.LocalDateTime;


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