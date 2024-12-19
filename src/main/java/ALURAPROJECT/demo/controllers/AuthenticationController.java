package ALURAPROJECT.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.classes.User.DadosUserDto;
import ALURAPROJECT.demo.classes.User.RegisterUserDto;
import ALURAPROJECT.demo.classes.User.User;
import ALURAPROJECT.demo.repository.RepositoryUser;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class AuthenticationController {

@Autowired
private AuthenticationManager manager;
  @Autowired
    private RepositoryUser userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

@PostMapping("/login")
@Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUserDto dados ){
        var token= new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication= manager.authenticate(token);

        
        return ResponseEntity.ok().build();

    }
@PostMapping("/register")    
@Transactional
    public ResponseEntity efetuarRegistro(@RequestBody @Valid RegisterUserDto dados){

        var novoUser = new User(dados);
        userRepository.save(novoUser);


    }
   
    }
    
