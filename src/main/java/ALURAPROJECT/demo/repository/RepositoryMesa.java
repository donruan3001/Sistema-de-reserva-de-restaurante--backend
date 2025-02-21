package ALURAPROJECT.demo.repository;

import org.hibernate.query.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ALURAPROJECT.demo.classes.mesas.Mesa;

public interface RepositoryMesa extends JpaRepository<Mesa,Long>{

    Object findAll(Pageable paginacao);

}
