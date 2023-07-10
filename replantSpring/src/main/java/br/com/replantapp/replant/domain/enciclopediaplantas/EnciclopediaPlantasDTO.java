package br.com.replantapp.replant.domain.enciclopediaplantas;

import br.com.replantapp.replant.domain.cardplanta.CardPlantaResponseDTO;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaResponseDTO;


public record EnciclopediaPlantasDTO(EnciclopediaResponseDTO enciclopedia,
                                     CardPlantaResponseDTO cardPlanta) {
}
