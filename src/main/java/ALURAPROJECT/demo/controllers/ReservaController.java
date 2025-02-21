package ALURAPROJECT.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;


@RestController
@RequestMapping("reservas")
public class ReservaController {
   
@Autowired
private RepositoryChair repository;

}