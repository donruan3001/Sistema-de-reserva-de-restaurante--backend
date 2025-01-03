package ALURAPROJECT.demo.controllers;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.repository.RepositoryMesa;

@RestController
@RequestMapping("mesas")
public class ChairController {
@Autowired
private  RepositoryMesa repository;

@GetMapping("/{id}")
    public ResponseEntity listarChairId(@PathVariable Long id){
        
    
}



@GetMapping
public ResponseEntity<Page<DadosListagemChair>> listarChairs(Page paginacao){
    var page = repository.findAll(paginacao).map(DadosListagemChair::new);
    return ResponseEntity.ok(page);
}
}