package ALURAPROJECT.demo.classes.reservas;
import java.time.LocalDateTime;
import ALURAPROJECT.demo.classes.User.User;
import ALURAPROJECT.demo.classes.mesas.Mesa;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Reserva{
   
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    private LocalDateTime data_reserva;

    @Enumerated(EnumType.STRING)
    private EnumReservas status;
}
