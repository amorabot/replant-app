package br.com.replantapp.replant.domain.PlantaVirtual;

import br.com.replantapp.replant.domain.Sensor.Sensor;
import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "planta_virtual")
@Table(name = "planta_virtual")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"plantaID"})
public class PlantaVirtual {

    @EmbeddedId
    private PlantaVirtualID plantaID;

//    @MapsId("id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;
//
//    @MapsId("usuarioId")
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuarioId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "sensor_serial_id", referencedColumnName = "serial_id"),
            @JoinColumn(name = "usuario_id_sensor", referencedColumnName = "usuario_id")
    })
    private Sensor sensor; //Mapping the plant's sensor

    //ADICIONAR O @ManyToOne PRO CARDPLANTA (unidirecional, cardplanta n precisa saber de plantavirtual
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id", nullable = false) //Non-optional attribute
//    private CardPlanta associatedCard;

    @Column(name = "foto")
    private String urlFoto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ultima_rega")
    private Date ultimaRega;

    @Column(name = "umidade_estimada")
    private int umidade;

    public static PlantaVirtualResponseDTO mapToDTO(PlantaVirtual plantaVirtual){
        PlantaVirtualID plantaVirtualID = plantaVirtual.getPlantaID();
        Sensor sensorPlanta;
        if (plantaVirtual.getSensor() == null){
            return new PlantaVirtualResponseDTO(
                    plantaVirtualID.getId(),
                    plantaVirtualID.getUsuario().getId(),
                    null,
                    null,
                    plantaVirtual.getUrlFoto(),
                    plantaVirtual.getNome(),
                    plantaVirtual.getDescricao(),
                    plantaVirtual.getUltimaRega(),
                    plantaVirtual.getUmidade());
        }
        sensorPlanta = plantaVirtual.getSensor();
        return new PlantaVirtualResponseDTO(
                plantaVirtualID.getId(),
                plantaVirtualID.getUsuario().getId(),
                sensorPlanta.getSensorID().getSerialId(),
                Sensor.mapToInfo(sensorPlanta),
                plantaVirtual.getUrlFoto(),
                plantaVirtual.getNome(),
                plantaVirtual.getDescricao(),
                plantaVirtual.getUltimaRega(),
                plantaVirtual.getUmidade());
    }
    public static PlantaVirtualInfo mapToInfo(PlantaVirtual plantaVirtual){
        return new PlantaVirtualInfo(
                plantaVirtual.getPlantaID().getId(),
                plantaVirtual.getNome(),
                plantaVirtual.getDescricao());
    }
}
