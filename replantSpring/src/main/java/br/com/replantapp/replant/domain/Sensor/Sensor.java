package br.com.replantapp.replant.domain.Sensor;


import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtual;
import br.com.replantapp.replant.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "sensor")
@Table(name = "sensor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"sensorID"})
public class Sensor {

    @EmbeddedId
    private SensorID sensorID;

//    @MapsId("serialId")
//    @Column(name = "serial_id")
//    private String serialId;
//
//    @MapsId("usuarioId")
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuarioId; //FK for the associated user

    @Column(name = "umidade")
    private int umidade;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @OneToOne(mappedBy = "sensor", cascade = CascadeType.PERSIST)
    private PlantaVirtual planta;


    public static SensorResponseDTO mapToDTO(Sensor sensor){
        if (sensor.getPlanta() == null){
            return new SensorResponseDTO(
                    sensor.getSensorID().getSerialId(),
                    sensor.getUmidade(),
                    sensor.isAtivo(),
                    null);
        } else {
            PlantaVirtual plantaVirtualAssociada = sensor.getPlanta();
            return new SensorResponseDTO(
                    sensor.getSensorID().getSerialId(),
                    sensor.getUmidade(),
                    sensor.isAtivo(),
                    PlantaVirtual.mapToInfo(plantaVirtualAssociada));
        }
    }

    public static SensorInfo mapToInfo(Sensor sensor){
        return new SensorInfo(sensor.getUmidade(), sensor.isAtivo());
    }
    public static String generateSerialID(){
        return UUID.randomUUID().toString();
    }
}
