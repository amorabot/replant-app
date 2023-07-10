package br.com.replantapp.replant.domain.Sensor;

import org.springframework.lang.NonNull;

public record SensorUpdateRequestDTO(@NonNull String sensorSerialID,
                                     @NonNull int umidadeAtual) {
}
