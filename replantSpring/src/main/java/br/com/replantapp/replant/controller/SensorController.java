package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtual;
import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtualID;
import br.com.replantapp.replant.domain.PlantaVirtual.PlantaVirtualRepository;
import br.com.replantapp.replant.domain.Sensor.*;
import br.com.replantapp.replant.domain.usuario.Usuario;
import br.com.replantapp.replant.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    @Autowired
    SensorRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PlantaVirtualRepository plantaVirtualRepository;

    @GetMapping("/{userId}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SensorResponseDTO>> getAllSensores(@PathVariable String userId){
        Optional<Usuario> fetchedUsuario = usuarioRepository.findById(userId);
        if (fetchedUsuario.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Usuario sensorOwner = fetchedUsuario.get();
        List<Sensor> sensores = repository.findBySensorID_Usuario(sensorOwner);
        List<SensorResponseDTO> infoSensores = new ArrayList<>();
        for (Sensor sensor : sensores){
            infoSensores.add(Sensor.mapToDTO(sensor));
        }

        return ResponseEntity.ok(infoSensores);
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> registerSensor(@RequestBody SensorRequestDTO newSensorData){
        Sensor newSensor = new Sensor();
        SensorID sensorID = new SensorID();
        //Setting up the Sensor's ID
        sensorID.setSerialId(Sensor.generateSerialID());
        Optional<Usuario> fetchedUsuario = usuarioRepository.findById(newSensorData.ownerID());
        if (fetchedUsuario.isEmpty()){
            return ResponseEntity.badRequest().body("O ID para o dono deste sensor não existe");
        }
        Usuario sensorOwner = fetchedUsuario.get();
        sensorID.setUsuario(sensorOwner);

        //Setting the standart values for a new sensor
        newSensor.setSensorID(sensorID);
        newSensor.setUmidade(0);
        newSensor.setAtivo(true);

        //Checking if the given associated plant ID exists (even if not given [ 0 in this case ] )
        PlantaVirtualID associatedPlantID = new PlantaVirtualID(newSensorData.plantaAssociadaID(), sensorOwner);
        Optional<PlantaVirtual> fetchedAssociatedPlant = plantaVirtualRepository.findByPlantaID(associatedPlantID);
        if (fetchedAssociatedPlant.isEmpty()){
            //Persisting the changes
            newSensor.setPlanta(null);
            repository.save(newSensor);
            return ResponseEntity.ok(
                    "O ID da planta virtual que foi fornecido não está registrado!" +
                            " Por enquanto não associamos nenhuma planta ao sensor, mas isso pode ser feito em outro momento!");
        } else {
            PlantaVirtual associatedPlant = fetchedAssociatedPlant.get();
            associatedPlant.setSensor(newSensor);
            plantaVirtualRepository.save(associatedPlant);
            //Essa ordem de operações só é possivel pois PlantaVirtual é a dona da relação 1-1 e foi definido no @OneToOne dela o cascade = CascateType.PERSIST
            // * isso nos permite, ao persistir o objeto que é o dono da relação, os objetos associados àquela relação são persistidos por tabela

//            newSensor.setPlanta(associatedPlant);
//            repository.save(newSensor);
//            newSensor.getPlanta().setSensor(newSensor);
//            plantaVirtualRepository.save(newSensor.getPlanta());

            return ResponseEntity.ok("Registro do sensor feito com sucesso!");
        }
    }
}
