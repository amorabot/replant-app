package br.com.replantapp.replant.domain.usuario;

import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaResponseDTO;
import org.springframework.lang.NonNull;

public record UsuarioResponseDTO(@NonNull String id,
                                 @NonNull String email,
                                 @NonNull String nome,
                                 @NonNull String regiao,
                                 @NonNull String tema,
                                 @NonNull int tempoDeAtualizacaoSensor,
                                 @NonNull EnciclopediaResponseDTO enciclopedia) {
}
