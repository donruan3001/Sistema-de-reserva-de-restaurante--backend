package ALURAPROJECT.demo.controllers;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.User.User;
import ALURAPROJECT.demo.domain.mesas.Mesa;
import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;
import ALURAPROJECT.demo.domain.reservas.CreateBookingDto;
import ALURAPROJECT.demo.domain.reservas.EnumBooking;
import ALURAPROJECT.demo.domain.reservas.RepositoryBooking;
import ALURAPROJECT.demo.domain.reservas.Reserva;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ALURAPROJECT.demo.domain.reservas.ListagemReservaDto;
import ALURAPROJECT.demo.domain.reservas.UpdateReservaDto;

@RestController
@RequestMapping("booking")
public class ReservaController {

@Autowired
private RepositoryBooking repositoryBooking;

@Autowired
private RepositoryChair repositoryChair;

@Autowired
private RepositoryUser repositoryUser;


@PostMapping
@Transactional
public ResponseEntity PostBooking(@RequestBody @Valid CreateBookingDto dados) {
    User user = repositoryUser.findById(dados.userId())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    Mesa mesa = repositoryChair.findById(dados.chairId())
        .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

    if(mesa.getStatus() != EnumStatusMesa.DISPONIVEL){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A mesa escolhida está indisponível"); }

    
    
    Reserva reserva = new Reserva(user,mesa,dados.data_reserva(),dados.status());
    
    mesa.setStatus(EnumStatusMesa.INDISPONIVEL);
    repositoryBooking.save(reserva);
   
    return ResponseEntity.status(HttpStatus.CREATED).body(reserva);

}
@GetMapping
public ResponseEntity<Page<ListagemReservaDto>> listarReservas(Pageable paginacao) {
    var page = repositoryBooking.findAll(paginacao).map(ListagemReservaDto::new);
    return ResponseEntity.ok(page);
}

@PatchMapping("/{id}")
@Transactional
public ResponseEntity CancelarReserva(@PathVariable Long id) {
    try{
        var reserva = repositoryBooking.findById(id)
        .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        if(reserva.getStatus()==EnumBooking.ATIVO){
            reserva.setStatus(EnumBooking.CANCELADO);
        
            var mesa = reserva.getMesa();
            mesa.setStatus(EnumStatusMesa.DISPONIVEL);
        
            repositoryChair.save(mesa);
            repositoryBooking.save(reserva);
            return ResponseEntity.ok().build();}
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva não está ativa e não pode ser cancelada");
            }

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva não encontrada");
        }
    }

 }

  
