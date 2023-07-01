package br.com.replantapp.replant.domain.usuario;

import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import org.springframework.lang.NonNull;

public record UsuarioRequestDTO(         String id,
                                @NonNull int enciclopedia_id,
                                @NonNull String email,
                                @NonNull String nome,
                                @NonNull String regiao,
                                @NonNull String tema,
                                         int refresh_timer
) {
}
