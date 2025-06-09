package ALURAPROJECT.demo.domain.reservas.services;

import java.util.List;

import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;
import ALURAPROJECT.demo.domain.reservas.EnumBooking;
import ALURAPROJECT.demo.domain.reservas.RepositoryBooking;
import ALURAPROJECT.demo.domain.reservas.Reserva;
import ALURAPROJECT.demo.domain.reservas.Dto.CreateBookingDto;
import ALURAPROJECT.demo.domain.reservas.validadores.Validador;

@Service
public class BookingService {

@Autowired
RepositoryBooking repositoryBooking;

@Autowired
RepositoryChair repositoryChair;

@Autowired
RepositoryUser repositoryUser;

@Autowired
private List<Validador> validadores;

public void criarReserva(CreateBookingDto dados){
 
    validadores.forEach(v -> v.validar(dados)); 

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


