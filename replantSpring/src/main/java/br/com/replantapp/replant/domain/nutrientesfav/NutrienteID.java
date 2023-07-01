package br.com.replantapp.replant.domain.nutrientesfav;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"nutriente", "cardPlanta"})
@Embeddable
public class NutrienteID implements Serializable {

    private String nutriente;
    private CardPlanta cardPlanta;

    public NutrienteID(String nutriente, CardPlanta cardPlanta){
        this.nutriente = nutriente;
        this.cardPlanta = cardPlanta;
    }
}
