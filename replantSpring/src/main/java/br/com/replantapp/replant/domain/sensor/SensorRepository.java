package br.com.replantapp.replant.domain.sensor;

import br.com.replantapp.replant.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, SensorID> {

    Optional<Sensor> findBySensorID(SensorID id);

    List<Sensor> findBySensorID_SerialId(String serialId);
    List<Sensor> findBySensorID_Usuario(Usuario usuario);
}
