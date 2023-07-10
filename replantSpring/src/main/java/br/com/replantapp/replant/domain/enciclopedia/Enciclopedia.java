package br.com.replantapp.replant.domain.enciclopedia;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaResponseDTO;
import br.com.replantapp.replant.domain.enciclopediaplantas.EnciclopediaPlantas;
import br.com.replantapp.replant.enums.Regions;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "enciclopedia")
@Table(name = "enciclopedia")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Enciclopedia {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="regiao", nullable = false)
    @Enumerated(EnumType.STRING)
    private Regions regiao;
    @Column(name="descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "enciclopedia")
    Set<EnciclopediaPlantas> enciclopediaPlantas; //Precisa ser um set, considerando a unicidade de cada entry, nao podem haver repeticoes

    public Enciclopedia(EnciclopediaRequestDTO enciclopediaData){
        try {
            String uppercaseRegion = enciclopediaData.regiao().toUpperCase().strip();
            this.regiao = Regions.valueOf(uppercaseRegion);
        } catch (IllegalArgumentException exception){
            this.regiao = Regions.NORDESTE;
        }
        this.descricao = enciclopediaData.descricao();
    }

    public static EnciclopediaResponseDTO mapToDTO(Enciclopedia entity){
        Set<CardPlantaResponseDTO> allCardEntries = new HashSet<>();

        for (EnciclopediaPlantas entry : entity.getEnciclopediaPlantas()){
            allCardEntries.add(CardPlanta.mapToDTO(entry.getCard()));
        }

        return new EnciclopediaResponseDTO(
                entity.getId(),
                entity.getRegiao().toString(),
                entity.getDescricao(),
                allCardEntries);
    }
}
