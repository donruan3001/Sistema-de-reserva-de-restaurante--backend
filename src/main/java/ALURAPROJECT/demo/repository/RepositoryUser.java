package ALURAPROJECT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ALURAPROJECT.demo.classes.User.User;

public interface RepositoryUser extends JpaRepository<User,Long>{

    User findByEmail(String email);

}
