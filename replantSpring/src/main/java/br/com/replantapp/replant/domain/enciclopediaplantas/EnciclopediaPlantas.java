package br.com.replantapp.replant.domain.enciclopediaplantas;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "enciclopedia_plantas")
@Table(name = "enciclopedia_plantas")
//@IdClass(EnciclopediaPlantasID.class)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"enciclopedia", "card"})
public class EnciclopediaPlantas {

    @EmbeddedId
    private EnciclopediaPlantasID id = new EnciclopediaPlantasID();

//    @Id
    @JoinColumn(name = "enciclopedia_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("enciclopediaId")
    private Enciclopedia enciclopedia;

//    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_planta_id")
    @MapsId("cardId")
    private CardPlanta card;

/*@ManyToOne relationship assumes that referenced entity exists. Foreign keys and database integrity ensure that these entities exist.*/

    public static EnciclopediaPlantasDTO mapToDTO(EnciclopediaPlantas entity){
        return new EnciclopediaPlantasDTO(
                Enciclopedia.mapToDTO(entity.getEnciclopedia()),
                CardPlanta.mapToDTO(entity.getCard()));
    }
}
