package br.com.replantapp.replant.domain.PlantaVirtual;

import br.com.replantapp.replant.domain.Sensor.SensorInfo;
import br.com.replantapp.replant.domain.Sensor.SensorResponseDTO;
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
                                       //TODO: ADICIONAR DADOS REFERENTES AO CARD PLANTA (DTO)
                                       @NonNull int umidade) {
}
