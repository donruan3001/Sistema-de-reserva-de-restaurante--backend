package ALURAPROJECT.demo.classes.mesas;



import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="mesas")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int capacidade;

    @Enumerated(EnumType.STRING)
    private EnumStatusMesa status;


    public Mesa(String nome, int capacidade, EnumStatusMesa status) {
        this.nome = nome;
        this.capacidade=capacidade;
        this.status = status;
}
}