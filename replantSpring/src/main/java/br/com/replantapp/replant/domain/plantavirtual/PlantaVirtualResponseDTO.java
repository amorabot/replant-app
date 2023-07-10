package br.com.replantapp.replant.domain.plantavirtual;

import br.com.replantapp.replant.domain.sensor.SensorInfo;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaInfo;
import org.springframework.lang.NonNull;

import java.util.Date;

public record PlantaVirtualResponseDTO(@NonNull int plantID,
                                       @NonNull String ownerID,
                                       String sensorSerialID,
                                       SensorInfo sensorData,
                                       @NonNull String urlFoto,
                                       @NonNull String nome,
                                       @NonNull String descricao,
                                       @NonNull Date ultimaRega,
                                       @NonNull CardPlantaInfo plantaInfo,
                                       @NonNull int umidade) {
}
