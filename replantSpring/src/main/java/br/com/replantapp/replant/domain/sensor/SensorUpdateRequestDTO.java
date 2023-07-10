package br.com.replantapp.replant.domain.sensor;

import org.springframework.lang.NonNull;

public record SensorUpdateRequestDTO(@NonNull String sensorSerialID,
                                     @NonNull int umidadeAtual) {
}
