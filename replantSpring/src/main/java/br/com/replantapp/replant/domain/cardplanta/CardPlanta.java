package br.com.replantapp.replant.domain.cardplanta;

import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaResponseDTO;
import br.com.replantapp.replant.domain.enciclopediaplantas.EnciclopediaPlantas;
import br.com.replantapp.replant.domain.nutrientesfav.NutrienteDTO;
import br.com.replantapp.replant.domain.nutrientesfav.NutrientesFavoritos;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "card_planta")
@Table(name = "card_planta")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CardPlanta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="nome_convencional", nullable = false)
    private String nome;
    @Column(name="nome_cientifico", nullable = false)
    private String nomeCientifico;
    @Column(name="descricao", nullable = false)
    private String descricao;
    @Column(name="regiao_nativa")
    private String regiaoNativa;
    @Column(name="tempo_rega", nullable = false)
    private int tempoRega;
    @Column(name="umidade_ideal", nullable = false)
    private int umidadeIdeal;

//    @OneToMany(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name = "card_planta_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "cardPlanta", fetch = FetchType.LAZY)
    private List<NutrientesFavoritos> nutrientesFavoritos = new ArrayList<>();

    @OneToMany(mappedBy = "card")
    private Set<EnciclopediaPlantas> enciclopediaPlantas;

    public CardPlanta(CardPlantaRequestDTO newCardData){
        this.nome = newCardData.nome();
        this.nomeCientifico = newCardData.nomeCientifico();
        this.descricao = newCardData.descricao();
        if (newCardData.regiaoNativa() != null){
            this.regiaoNativa = newCardData.regiaoNativa();
        } else {
            this.regiaoNativa = "Regiao nao definida!";
        }
        this.tempoRega = newCardData.tempoRega();
        this.umidadeIdeal = newCardData.umidadeIdeal();
        this.nutrientesFavoritos = newCardData.nutrientesFavoritos();
    }
    public static CardPlantaResponseDTO mapToDTO(CardPlanta entity){
        Set<NutrienteDTO> nutrienteDTOSet = new HashSet<>();
        for (NutrientesFavoritos nutriente : entity.getNutrientesFavoritos()){
            nutrienteDTOSet.add(new NutrienteDTO(nutriente.getNutriente()));
        }

//        Set<EnciclopediaResponseDTO> associatedEnciclopedias = new HashSet<>();
        Set<Integer> associatedEnciclopedias = new HashSet<>();
        for (EnciclopediaPlantas entry : entity.getEnciclopediaPlantas()){
//            associatedEnciclopedias.add(Enciclopedia.mapToDTO(entry.getEnciclopedia()));
            associatedEnciclopedias.add(entry.getEnciclopedia().getId());
        }

        return new CardPlantaResponseDTO(entity.getId(),
                entity.getNome(),
                entity.getNomeCientifico(),
                entity.getDescricao(),
                entity.getRegiaoNativa(),
                entity.getTempoRega(),
                entity.getUmidadeIdeal(),
                nutrienteDTOSet,
                associatedEnciclopedias);
    }
}