package br.com.replantapp.replant.domain.nutrientesfav;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "nutrientes_favoritos")
@Table(name = "nutrientes_favoritos")
@IdClass(NutrienteID.class)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"nutriente", "cardPlanta"})
public class NutrientesFavoritos {

    @Id @Column(name="nutriente")
    private String nutriente;

    @ManyToOne
    @Id @JoinColumn(name = "card_planta_id")
    private CardPlanta cardPlanta;
}
