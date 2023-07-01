package br.com.replantapp.replant.domain.cardplanta;

import br.com.replantapp.replant.domain.nutrientesfav.NutrientesFavoritos;
import org.springframework.lang.NonNull;

import java.util.List;

public record CardPlantaRequestDTO(int id,
                                   @NonNull String nome,
                                   @NonNull String nomeCientifico,
                                   @NonNull String descricao,
                                   String regiaoNativa,
                                   @NonNull int tempoRega,
                                   @NonNull int umidadeIdeal,
                                   @NonNull List<NutrientesFavoritos> nutrientesFavoritos) {
}
