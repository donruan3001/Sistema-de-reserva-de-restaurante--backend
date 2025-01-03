package ALURAPROJECT.demo.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import ALURAPROJECT.demo.classes.User.User;



@Service
public class TokenService {
@Value("${JWT_SECRET}")
private String secret;

    public String gerarToken(User usuario){

try {
    System.out.println(secret);

    var algorithm = Algorithm.HMAC256(secret);

    return JWT.create()
        .withIssuer("API restaurante")
        .withSubject(usuario.getEmail())
        .withExpiresAt(dataExpiracao())
        .sign(algorithm);

} catch (JWTCreationException exception){
   throw new RuntimeException("Erro ao gerar token ",exception);
}
    }

private Instant dataExpiracao() {
    return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
}
}