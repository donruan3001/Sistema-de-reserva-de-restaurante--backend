package ALURAPROJECT.demo.domain.reservas;

import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;

@Service
public class BookkingService {

@Autowired
RepositoryBooking repositoryBooking;

@Autowired
RepositoryChair repositoryChair;

@Autowired
RepositoryUser repositoryUser;

public void criarReserva(CreateBookingDto dados){

  if (!repositoryChair.existsById(dados.chairId())) {
        throw new RuntimeErrorException(null, "id da mesa não existe");
    }
    if (!repositoryUser.existsById(dados.userId())) {
        throw new RuntimeErrorException(null, "id do user não existe");
    }

    var mesa = repositoryChair.findById(dados.chairId()).get();
    var user = repositoryUser.findById(dados.userId()).get();

    if (mesa.getStatus() == EnumStatusMesa.INDISPONIVEL) {
        throw new RuntimeErrorException(null, "mesa indisponível, não é possível realizar a reserva");
    }

    Reserva reserva = new Reserva(user, mesa, dados.data_reserva(), dados.status());
    mesa.setStatus(EnumStatusMesa.INDISPONIVEL);
    repositoryBooking.save(reserva);
   }

public void atualizarReserva(Long id){



}   
    }


