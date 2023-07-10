package br.com.replantapp.replant.domain.sensor;

import br.com.replantapp.replant.domain.plantavirtual.PlantaVirtualInfo;
import org.springframework.lang.NonNull;

public record SensorResponseDTO(String serialId,
                                @NonNull int umidade,
                                @NonNull boolean ativo,
                                PlantaVirtualInfo plantaAssociada) {
}
