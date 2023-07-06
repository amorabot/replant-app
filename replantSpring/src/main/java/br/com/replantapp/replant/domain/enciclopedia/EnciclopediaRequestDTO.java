package br.com.replantapp.replant.domain.enciclopedia;

import org.springframework.lang.NonNull;

public record EnciclopediaRequestDTO(int id,
                                     @NonNull String regiao,
                                     @NonNull String descricao) {
}
