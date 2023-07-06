package br.com.replantapp.replant.domain.Sensor;

import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtualInfo;
import org.springframework.lang.NonNull;

public record SensorResponseDTO(String serialId,
                                @NonNull int umidade,
                                @NonNull boolean ativo,
                                PlantaVirtualInfo plantaAssociada) {
}
