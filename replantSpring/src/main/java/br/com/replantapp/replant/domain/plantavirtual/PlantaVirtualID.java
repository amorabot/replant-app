package br.com.replantapp.replant.domain.plantavirtual;

import br.com.replantapp.replant.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "usuario"})
public class PlantaVirtualID implements Serializable {

    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
