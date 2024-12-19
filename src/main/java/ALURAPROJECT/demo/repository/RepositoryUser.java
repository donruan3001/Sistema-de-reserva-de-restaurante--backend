package ALURAPROJECT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import ALURAPROJECT.demo.classes.User.User;

public interface RepositoryUser extends JpaRepository<User,Long>{

    UserDetails findByEmail(String email);

}
