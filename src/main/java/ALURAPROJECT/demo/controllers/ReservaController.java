package ALURAPROJECT.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import ALURAPROJECT.demo.domain.reservas.RepositoryBooking;
import ALURAPROJECT.demo.domain.reservas.Dto.CreateBookingDto;
import ALURAPROJECT.demo.domain.reservas.Dto.ListagemReservaDto;
import ALURAPROJECT.demo.domain.reservas.services.BookingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("booking")
public class ReservaController {

@Autowired
private RepositoryBooking repositoryBooking;


@Autowired
BookingService bookingService;

@PostMapping
@Transactional
public ResponseEntity PostBooking(@RequestBody @Valid CreateBookingDto dados) {
   
    bookingService.criarReserva(dados);
    return ResponseEntity.status(HttpStatus.CREATED).body(dados);

}
@GetMapping
public ResponseEntity<Page<ListagemReservaDto>> listarReservas(Pageable paginacao) {
    var page = repositoryBooking.findAll(paginacao).map(ListagemReservaDto::new);
    return ResponseEntity.ok(page);
}

@PatchMapping("/{id}")
@Transactional
public ResponseEntity CancelarReserva(@PathVariable Long id) {
  bookingService.atualizarReserva(id);

  return ResponseEntity.ok().build();
    }

 }

  
