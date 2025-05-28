package ALURAPROJECT.demo.controllers;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.User.User;
import ALURAPROJECT.demo.domain.mesas.Mesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;
import ALURAPROJECT.demo.domain.reservas.CreateBookingDto;
import ALURAPROJECT.demo.domain.reservas.RepositoryBooking;
import ALURAPROJECT.demo.domain.reservas.Reserva;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



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

    Reserva reserva = new Reserva(dados.chairId(),mesa,dados.data_reserva(),dados.status());
    repositoryBooking.save(reserva);
   return ResponseEntity.status(HttpStatus.CREATED).body(reserva);

}
@GetMapping()
public String getMethodName(@RequestParam String param) {
    return new String();
}}
