package ALURAPROJECT.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ALURAPROJECT.demo.domain.User.UserLoginDto;
import ALURAPROJECT.demo.domain.User.UserRegisterDto;
import ALURAPROJECT.demo.domain.User.RepositoryUser;
import ALURAPROJECT.demo.domain.User.User;
import ALURAPROJECT.demo.infra.security.TokenJWT;
import ALURAPROJECT.demo.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

@Autowired
private PasswordEncoder passwordEncoder;

@Autowired
private RepositoryUser repository;

@Autowired
private AuthenticationManager manager;

@Autowired
private TokenService tokenService;

@PostMapping("/login")
@Transactional
    public ResponseEntity loginIn(@RequestBody @Valid UserLoginDto dados ){
        try{

            var tokenAuthentication= new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication= manager.authenticate(tokenAuthentication);
            var tokenJwt=tokenService.gerarToken((User)authentication.getPrincipal());
    
            return ResponseEntity.ok(new TokenJWT(tokenJwt));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());}

    }
@PostMapping("/register")
@Transactional
public ResponseEntity register(@RequestBody @Valid  UserRegisterDto dados) {
    
    if(repository.findByEmail(dados.email())!=null)return ResponseEntity.badRequest().build();
    
    var senhaEncrypted= passwordEncoder.encode(dados.senha());
    User newUser= new User(dados.nome(),dados.email(),senhaEncrypted,dados.role());
    
    this.repository.save(newUser);

    return ResponseEntity.ok().build();
    }
}
    
    
