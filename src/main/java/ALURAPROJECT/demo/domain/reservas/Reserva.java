package ALURAPROJECT.demo.domain.reservas;


import java.time.LocalDateTime;

import ALURAPROJECT.demo.domain.User.User;
import ALURAPROJECT.demo.domain.mesas.Mesa;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="reservas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Reserva{
   
   @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    private LocalDateTime data_reserva;

    @Enumerated(EnumType.STRING)
    private EnumBooking status;

    public Reserva(User user,Mesa mesa, LocalDateTime data_reserva,EnumBooking status){
        this.user=user;
        this.mesa=mesa;
        this.data_reserva=data_reserva;
        this.status=status;
    }
  public Reserva(Long userId, Long mesaId, LocalDateTime horario, EnumBooking status) {
        this.user = new User();
        this.user.setId(userId);

        this.mesa = new Mesa();
        this.mesa.setId(mesaId);

        this.data_reserva = horario;
        this.status = status;
    }


}
