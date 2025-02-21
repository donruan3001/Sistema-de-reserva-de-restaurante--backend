package ALURAPROJECT.demo.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface RepositoryUser extends JpaRepository<User,Long>{

    UserDetails findByEmail(String email);

}
