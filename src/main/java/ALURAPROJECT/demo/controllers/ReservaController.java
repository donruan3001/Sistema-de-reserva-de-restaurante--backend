package ALURAPROJECT.demo.controllers;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("reservas")
public class ReservaController {
   
@Autowired
private RepositoryBooking repositoryBooking;

@Autowired
private RepositoryChair repositoryChair;

@Autowired
private RepositoryUser repositoryUser;


@PostMapping()
public ResponseEntity PostBooking(@RequestBody @Valid CreateBookingDto dados) {
    
    Optional<User> userOpt= repositoryUser.findById(CreateBookingDto.userId());
    if (userOpt.isEmpty()) return ResponseEntity.status(400).build();

    Optional<Mesa> chairOpt=repositoryChair.findById(CreateBookingDto.chairId());
    if (chairOpt.isEmpty()) return ResponseEntity.status(400).build();

    LocalDateTime dataReserva=CreateBookingDto.data_reserva();

}
@GetMapping()
public String getMethodName(@RequestParam String param) {
    return new String();
}

@PatchMapping
public ResponseEntity autualizarBooking(){}

}