package br.com.replantapp.replant.domain.cardplanta;

import br.com.replantapp.replant.domain.nutrientesfav.NutrienteDTO;
import org.springframework.lang.NonNull;

import java.util.Set;

public record CardPlantaInfo(@NonNull String nome,
                             @NonNull String nomeCientifico,
                             @NonNull String regiaoNativa,
                             @NonNull int tempoRega,
                             @NonNull int umidadeIdeal,
                             @NonNull Set<NutrienteDTO> nutrientesFavoritos) {
}
