package br.com.replantapp.replant.domain.enciclopediaplantas;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaResponseDTO;
import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaResponseDTO;

import java.util.Set;

public record EnciclopediaPlantasDTO(EnciclopediaResponseDTO enciclopedia,
                                     CardPlantaResponseDTO cardPlanta) {
}
