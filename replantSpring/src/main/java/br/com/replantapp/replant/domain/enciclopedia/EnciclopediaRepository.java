package br.com.replantapp.replant.domain.enciclopedia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnciclopediaRepository extends JpaRepository<Enciclopedia, Integer> {
    List<Enciclopedia> findAllByRegiao(String regiao);
}
