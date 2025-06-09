package ALURAPROJECT.demo.domain.reservas.validadores;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.reservas.Dto.CreateBookingDto;
@Component
public class ValidadorUser implements Validador  {
    @Autowired
   private RepositoryUser repositoryUser;

    public void validar(CreateBookingDto dados){

    if (!repositoryUser.existsById(dados.userId())) {
        throw new RuntimeErrorException(null, "id do user não existe");
    }
    }

    

}
