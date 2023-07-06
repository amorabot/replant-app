package br.com.replantapp.replant.domain.PlantaVirtual;

import br.com.replantapp.replant.domain.Sensor.SensorInfo;
import br.com.replantapp.replant.domain.Sensor.SensorResponseDTO;
import org.springframework.lang.NonNull;

public record PlantaVirtualResponseDTO(@NonNull int plantID,
                                       @NonNull String ownerID,
                                       String sensorSerialID,
                                       SensorInfo sensorData,
                                       @NonNull String urlFoto,
                                       @NonNull String nome,
                                       @NonNull String descricao,
                                       //ADICIONAR DADOS DA ULTIMA REGA
                                       @NonNull int umidade) {
}
