package br.com.replantapp.replant.domain.usuario;

import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.enums.Regions;
import br.com.replantapp.replant.enums.Themes;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="usuario")
@Table(name="usuario") //precisa ser o nome da tabela no BD

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="uuid", nullable = false)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enciclopedia_id", nullable = false)
    private Enciclopedia enciclopedia;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    orphanRemoval = true -> maintains data integrity and auto-removes orphan entities

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="nome_completo", nullable = false)
    private String nome;

    @Column(name="regiao", nullable = false)
    @Enumerated(EnumType.STRING)
    private Regions regiao;

    @Column(name="tema", nullable = false)
    @Enumerated(EnumType.STRING)
    private Themes tema;
    @Column(name="refresh_timer", nullable = false)
    private int refresh_timer;

    public Usuario(UsuarioRequestDTO userDTO){
        this.email = userDTO.email();
        this.nome = userDTO.nome();

        try { //Setting the enum value for the given region string
            this.regiao = Regions.valueOf(userDTO.regiao().toUpperCase());
        } catch(IllegalArgumentException exception){
            this.regiao = Regions.NORDESTE;
        }
        try{ //Setting the enum value for the given theme string
            this.tema = Themes.valueOf(userDTO.tema().toUpperCase());
        } catch(IllegalArgumentException exception){
            this.tema = Themes.DEFAULT;
        }

        if (userDTO.refresh_timer() != 0){
            this.refresh_timer = userDTO.refresh_timer();
        } else {
            this.refresh_timer = 6; //Default value
        }
    }

    public static UsuarioResponseDTO mapToDTO(Usuario entity){
        return new UsuarioResponseDTO(
                entity.getId(),
                entity.getEmail(),
                entity.getNome(),
                entity.getRegiao().toString(),
                entity.getTema().toString(),
                entity.getRefresh_timer(),
                Enciclopedia.mapToDTO(entity.getEnciclopedia())
        );
    }
}
