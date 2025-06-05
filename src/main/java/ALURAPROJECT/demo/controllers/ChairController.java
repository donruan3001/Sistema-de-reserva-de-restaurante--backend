package ALURAPROJECT.demo.controllers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ALURAPROJECT.demo.domain.mesas.InserirChairDto;
import ALURAPROJECT.demo.domain.mesas.ListagemChairDto;
import ALURAPROJECT.demo.domain.mesas.Mesa;
import ALURAPROJECT.demo.domain.mesas.RepositoryChair;
import ALURAPROJECT.demo.domain.mesas.UpdateChairDto;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/mesas")
public class ChairController {
@Autowired
private  RepositoryChair repository;

@GetMapping
public ResponseEntity <Page<ListagemChairDto>>listarChairs(@PageableDefault(size=100, sort = {"id"})Pageable pageable){
    Page<ListagemChairDto> page = repository.findAll(pageable).map(ListagemChairDto::new);
    return ResponseEntity.ok(page);

}
@PostMapping
@PreAuthorize("hasRole('ADMIN')")
@Transactional
public ResponseEntity createChair (@Valid @RequestBody InserirChairDto dados){
    var chair = new Mesa(dados.nome(),dados.capacidade(),dados.status());
    repository.save(chair);
    return ResponseEntity.status(HttpStatus.CREATED).body(chair);

}
@PatchMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
@Transactional
public ResponseEntity updateChair (@PathVariable Long id, @Valid @RequestBody UpdateChairDto dados){
 
      Mesa chair = repository.findById(id)
                          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrada"));
        chair.update(dados.nome(),dados.capacidade(),dados.status());
   
      return ResponseEntity.ok(chair);
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
@Transactional
public ResponseEntity deleteChair (@PathVariable Long id){
    var chair = repository.findById(id);
    if(chair.isEmpty()){
        return ResponseEntity.notFound().build();
    }
    repository.delete(chair.get());

    return ResponseEntity.noContent().build();
}}

