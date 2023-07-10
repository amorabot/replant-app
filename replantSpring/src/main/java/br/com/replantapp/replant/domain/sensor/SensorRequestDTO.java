package br.com.replantapp.replant.domain.sensor;

import org.springframework.lang.NonNull;

public record SensorRequestDTO(@NonNull String ownerID,
                                        int plantaAssociadaID) {
}
