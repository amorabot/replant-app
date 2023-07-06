package br.com.replantapp.replant.domain.enciclopedia;

import br.com.replantapp.replant.domain.cardplanta.CardPlantaResponseDTO;
import br.com.replantapp.replant.domain.enciclopediaplantas.EnciclopediaPlantasDTO;

import java.util.Set;

public record EnciclopediaResponseDTO(int id,
                                      String regiao,
                                      String descricao,
                                      Set<CardPlantaResponseDTO> cardEntries) {
}
