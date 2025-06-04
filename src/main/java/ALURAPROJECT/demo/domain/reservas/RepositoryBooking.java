package ALURAPROJECT.demo.domain.reservas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBooking extends JpaRepository<Reserva,Long> {

}
