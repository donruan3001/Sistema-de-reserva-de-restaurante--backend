package ALURAPROJECT.demo.controllers;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.classes.mesas.InserirChairDto;
import ALURAPROJECT.demo.classes.mesas.Mesa;
import ALURAPROJECT.demo.classes.mesas.UpdateChairDto;
import ALURAPROJECT.demo.repository.RepositoryMesa;
import jakarta.validation.Valid;

@RestController
@RequestMapping("mesas")
public class ChairController {
@Autowired
private  RepositoryMesa repository;

@GetMapping
public ResponseEntity<Page<DadosListagemChair>> listarChairs(Pageable paginacao){
    var page = repository.findAll(paginacao);
    return ResponseEntity.ok(page);
}

@PostMapping
@Transactional
public ResponseEntity createChair (@Valid @RequestBody InserirChairDto dados){
    var chair = new Mesa(dados.nome(),dados.capacidade(),dados.status());
    repository.save(chair);
    return ResponseEntity.status(HttpStatus.CREATED).body(chair);

}

@PatchMapping("/{id}")
@Transactional
public ResponseEntity updateChair (@PathVariable Long id, @Valid @RequestBody UpdateChairDto dados){
 


}}