package br.com.replantapp.replant.domain.PlantaVirtual;

import org.springframework.lang.NonNull;

public record PlantaVirtualInfo(int plantaID,
                                String nome,
                                String descricao) {
}
