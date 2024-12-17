package ALURAPROJECT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ALURAPROJECT.demo.classes.mesas.Mesa;

public interface RepositoryMesa extends JpaRepository<Mesa,Long>{

}
