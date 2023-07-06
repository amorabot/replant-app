package br.com.replantapp.replant.domain.PlantaVirtual;

import org.springframework.lang.NonNull;

public record PlantaVirtualRequestDTO(@NonNull int plantID,
                                      @NonNull String ownerID,
                                      String sensorSerialID,
                                      String urlFoto,
                                      String nome,
                                      String descricao) {
}
