package br.com.replantapp.replant.domain.plantavirtual;

import br.com.replantapp.replant.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaVirtualRepository extends JpaRepository<PlantaVirtual, PlantaVirtualID> {

    Optional<PlantaVirtual> findByPlantaID(PlantaVirtualID id);

    List<PlantaVirtual> findAllByPlantaID_Id(int plantaId);
    List<PlantaVirtual> findAllByPlantaID_Usuario(Usuario usuario);
}
