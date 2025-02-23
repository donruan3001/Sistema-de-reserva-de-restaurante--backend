package ALURAPROJECT.demo.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ALURAPROJECT.demo.domain.User.RepositoryUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@Component
public class FilterSecurity extends OncePerRequestFilter{
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RepositoryUser repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                var tokenJwt = recuperarToken(request);

        if(tokenJwt!=null){
            var subject= tokenService.getSubject(tokenJwt);
            var usuario= repository.findByEmail(subject);
        
            if(usuario!=null){

                var authentication= new UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
            System.out.println("Logado na requisição");
        }
        filterChain.doFilter(request, response);
    }

    public String recuperarToken(HttpServletRequest request){
    var headerAutorization= request.getHeader("Authorization");
   if(headerAutorization!=null){

       return headerAutorization.replace("Bearer", "").trim();

   }
   return null;
}
}



