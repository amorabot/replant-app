package br.com.replantapp.replant.domain.enciclopediaplantas;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enciclopediaId", "cardId"})
@Embeddable
public class EnciclopediaPlantasID implements Serializable {

    @Column(name = "enciclopedia_id")
    private int enciclopediaId;

    @Column(name = "card_planta_id")
    private int cardId;

//    EnciclopediaPlantasID(int enciclopediaId, int cardId){
//        this.cardId = cardId;
//        this.enciclopediaId = enciclopediaId;
//    }
}
