package ALURAPROJECT.demo.domain.reservas.validadores;

import ALURAPROJECT.demo.domain.reservas.Dto.CreateBookingDto;

public interface Validador {
 void validar(CreateBookingDto dados);
}
