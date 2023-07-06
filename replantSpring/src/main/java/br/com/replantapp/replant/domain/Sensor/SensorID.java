package br.com.replantapp.replant.domain.Sensor;

import br.com.replantapp.replant.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"serialId", "usuario"})
public class SensorID implements Serializable {

    @Column(name = "serial_id", nullable = false)
    private String serialId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
