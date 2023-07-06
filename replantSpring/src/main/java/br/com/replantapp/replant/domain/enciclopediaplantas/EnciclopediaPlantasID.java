package br.com.replantapp.replant.domain.enciclopediaplantas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enciclopediaId", "cardId"})
public class EnciclopediaPlantasID implements Serializable {

    @Column(name = "enciclopedia_id")
    private int enciclopediaId;

    @Column(name = "card_planta_id")
    private int cardId;

}
