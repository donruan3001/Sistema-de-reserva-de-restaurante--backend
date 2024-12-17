package ALURAPROJECT.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.classes.User.DadosUserDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

@Autowired
private AuthenticationManager manager;

@PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUserDto dados ){
        var token= new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication= manager.authenticate(token);

        
        return ResponseEntity.ok().build();

    }
   
    }
    
