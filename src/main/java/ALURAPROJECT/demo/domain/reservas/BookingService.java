package ALURAPROJECT.demo.domain.reservas;

import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;

@Service
public class BookingService {

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

 var reserva = repositoryBooking.findById(id).get();

 if (repositoryBooking.existsById(id)){throw new RuntimeErrorException(null, "id da reserva não existe");}


    if(reserva.getStatus()== EnumBooking.ATIVO) {
        reserva.setStatus(EnumBooking.CANCELADO);
        var mesa=reserva.getMesa();
        mesa.setStatus(EnumStatusMesa.DISPONIVEL);

            repositoryChair.save(mesa);
            repositoryBooking.save(reserva);
    }else{
        throw new RuntimeErrorException(null,"A reserva ja foi cancelada, não é possível seguir com a sua solicitação");}


}   
    }


