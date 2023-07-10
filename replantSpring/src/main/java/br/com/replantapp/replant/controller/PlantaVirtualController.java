package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.plantavirtual.*;
import br.com.replantapp.replant.domain.sensor.Sensor;
import br.com.replantapp.replant.domain.sensor.SensorID;
import br.com.replantapp.replant.domain.sensor.SensorRepository;
import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaRepository;
import br.com.replantapp.replant.domain.usuario.Usuario;
import br.com.replantapp.replant.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantas")
public class PlantaVirtualController {

    @Autowired
    PlantaVirtualRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    CardPlantaRepository cardRepository;

    @GetMapping("/{userId}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<PlantaVirtualResponseDTO>> getAllPlantas(@PathVariable String userId){
        Optional<Usuario> fetchedUsuario = usuarioRepository.findById(userId);
        if (fetchedUsuario.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Usuario user = fetchedUsuario.get();
        List<PlantaVirtual> plantList = repository.findAllByPlantaID_Usuario(user);
        List<PlantaVirtualResponseDTO> plantaDTOs = new ArrayList<>();
        for (PlantaVirtual plant : plantList){
            plantaDTOs.add(PlantaVirtual.mapToDTO(plant));
        }

        return ResponseEntity.ok(plantaDTOs);
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> registerPlantaVirtual(@RequestBody PlantaVirtualRequestDTO newPlantaVirtualData){
            /*
            Pet pet = new Pet();
            pet.setId(1);
            CollarId collarId = new CollarId();
            collarId.setPet(pet);
            collarId.setSerialId(1L);
            Collar byCollarIdIs = collarRepository.findById(collarId).orElseThrow();
            */
        String userId = newPlantaVirtualData.ownerID();
        Optional<Usuario> fetchedUsuario = usuarioRepository.findById(userId);
        if (fetchedUsuario.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        PlantaVirtual novaPlanta = new PlantaVirtual();
        PlantaVirtualID plantaID = new PlantaVirtualID();

        Usuario plantOwner = fetchedUsuario.get();
        plantaID.setId(newPlantaVirtualData.plantID());
        plantaID.setUsuario(plantOwner);
        //Checar se esse id de planta ja foi escoliho pelo usuario
        Optional<PlantaVirtual> plantaVirtualOptional = repository.findByPlantaID(plantaID);
        if (plantaVirtualOptional.isPresent()){
            return ResponseEntity.badRequest().body("Esse ID já pertence a outra planta sua! Escolha outro número para identificar sua nova plantinha.");
        }

        novaPlanta.setPlantaID(plantaID);

        //Criar associação entre planta e cardPlanta
        Optional<CardPlanta> fetchedCard = cardRepository.findById(newPlantaVirtualData.cardID());
        if (fetchedCard.isEmpty()){
            return ResponseEntity.badRequest().body("O Card escolhido não está registrado em nenhum lugar!");
        }//A partir daqui temos certeza de que há um card válido associado, portanto, basta associá-lo ao tamagotchi.
        CardPlanta card = fetchedCard.get();
        novaPlanta.setAssociatedCard(card);

        novaPlanta.setUrlFoto(newPlantaVirtualData.urlFoto());
        novaPlanta.setNome(newPlantaVirtualData.nome());
        novaPlanta.setDescricao(newPlantaVirtualData.descricao());

        //Checking if the given Sensor ID exists
        SensorID givenSensorID = new SensorID(newPlantaVirtualData.sensorSerialID(), plantOwner);
        Optional<Sensor> fetchedSensor = sensorRepository.findBySensorID(givenSensorID);
        if (fetchedSensor.isPresent()){
            novaPlanta.setSensor(fetchedSensor.get());
        }

        repository.save(novaPlanta);
        return ResponseEntity.ok("Tamagotchi registrado!");
    }
}
