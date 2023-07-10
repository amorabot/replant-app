package br.com.replantapp.replant.domain.userDEPRECATED;

import org.springframework.lang.NonNull;
//import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(         String id,
                             @NonNull String name,
                             @NonNull String region,
                             @NonNull String url) {
    // Request: pedido que vem do client com dados associados
}