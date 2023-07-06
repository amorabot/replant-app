package br.com.replantapp.replant.domain.usuario;

//import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtual;
//import br.com.replantapp.replant.domain.Sensor.Sensor;
import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.enums.Regions;
import br.com.replantapp.replant.enums.Themes;
import jakarta.persistence.*;
import lombok.*;

//import java.util.ArrayList;
//import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enciclopedia_id", nullable = false)
    private Enciclopedia enciclopedia;

//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PlantaVirtual> plantasVirtuais = new ArrayList<>();
    //Owns the 1 - N relationship, we need to map the N - 1 side too
    // orphanRemoval = true -> maintains data integrity and auto-removes orphan entities
    // Ordem das operações -> adicionar o usuario à planta virtual e então salvá-la
    /*
    Order o = em.find(Order.class, 1L);

    OrderItem i = new OrderItem();
    i.setOrder(o);

    o.getItems().add(i);

    em.persist(i);
    * */

//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Sensor> sensores = new ArrayList<>(); // A lógica é a mesma para a relação das plantas

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
