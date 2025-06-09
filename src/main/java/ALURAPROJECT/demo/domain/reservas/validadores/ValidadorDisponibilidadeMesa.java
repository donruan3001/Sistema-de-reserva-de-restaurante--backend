package ALURAPROJECT.demo.domain.reservas.validadores;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ALURAPROJECT.demo.domain.mesas.RepositoryChair;
import ALURAPROJECT.demo.domain.reservas.Dto.CreateBookingDto;

@Component
public class ValidadorDisponibilidadeMesa implements Validador {

    @Autowired
    private RepositoryChair  repositoryChair;


    public void validar(CreateBookingDto dados){

           
  if (!repositoryChair.existsById(dados.chairId())) {
        throw new RuntimeErrorException(null, "id da mesa não existe");
    }


    }

}
