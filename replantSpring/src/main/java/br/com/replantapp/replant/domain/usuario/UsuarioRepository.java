package br.com.replantapp.replant.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    public Optional<Usuario> findByEmail(String email);
}
