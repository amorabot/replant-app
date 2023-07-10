package br.com.replantapp.replant.domain.plantavirtual;

import org.springframework.lang.NonNull;

public record PlantaVirtualRequestDTO(@NonNull int plantID,
                                      @NonNull String ownerID,
                                      @NonNull int cardID,
                                      String sensorSerialID,
                                      String urlFoto,
                                      String nome,
                                      String descricao) {
}
