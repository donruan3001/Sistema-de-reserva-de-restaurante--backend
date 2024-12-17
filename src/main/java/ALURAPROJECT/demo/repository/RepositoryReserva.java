package ALURAPROJECT.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ALURAPROJECT.demo.classes.reservas.Reserva;

public interface RepositoryReserva extends JpaRepository<Reserva,Long>{

}
