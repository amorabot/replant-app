package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaRepository;
import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaRepository;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaRequestDTO;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaResponseDTO;
import br.com.replantapp.replant.domain.enciclopediaplantas.EnciclopediaPlantas;
import br.com.replantapp.replant.domain.enciclopediaplantas.EnciclopediaPlantasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/enciclopedias")
public class EnciclopediaController {

    @Autowired
    EnciclopediaRepository repository;
    @Autowired
    CardPlantaRepository cardRepository;
    @Autowired
    EnciclopediaPlantasRepository enciclopediaCardsRepository;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Set<EnciclopediaResponseDTO>> getAllEnciclopedias(){

        List<Enciclopedia> allEnciclopedias = repository.findAll();
        Set<EnciclopediaResponseDTO> enciclopediaDTOs = new HashSet<>();
        for (Enciclopedia enciclopedia : allEnciclopedias){
            enciclopediaDTOs.add(Enciclopedia.mapToDTO(enciclopedia));
        }

        return ResponseEntity.ok(enciclopediaDTOs);
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> createEnciclopedia(@RequestBody @Validated EnciclopediaRequestDTO newEnciclopediaData){

        Enciclopedia novaEnciclopedia = new Enciclopedia(newEnciclopediaData);
        repository.save(novaEnciclopedia);

        return ResponseEntity.ok("Registro de enciclopedia bem sucedido!");
    }

    @PutMapping("/{enciclopediaId}")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> addCards(@PathVariable int enciclopediaId, @RequestBody List<Integer> cardIds){

        Optional<Enciclopedia> fetchedEnciclopedia = repository.findById(enciclopediaId);
        if (fetchedEnciclopedia.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Enciclopedia enciclopedia = fetchedEnciclopedia.get();
        System.out.println("Fetch da enciclopedia bem sucedido!");

        for (Integer id : cardIds){
            Optional<CardPlanta> optCardPlanta = cardRepository.findById(id);
            if (optCardPlanta.isPresent()){
                EnciclopediaPlantas newEnciclopediaPlantas = new EnciclopediaPlantas();

                CardPlanta card = optCardPlanta.get();

                 newEnciclopediaPlantas.setEnciclopedia(enciclopedia);
                 newEnciclopediaPlantas.setCard(card);

                System.out.println("salvando jointable");
                enciclopediaCardsRepository.save(newEnciclopediaPlantas);

            }
        }

        return ResponseEntity.ok().build();
    }

}
