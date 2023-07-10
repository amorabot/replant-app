package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.cardplanta.CardPlanta;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaRepository;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaRequestDTO;
import br.com.replantapp.replant.domain.cardplanta.CardPlantaResponseDTO;
import br.com.replantapp.replant.domain.nutrientesfav.NutrientesFavoritos;
import br.com.replantapp.replant.domain.nutrientesfav.NutrientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cards")
public class CardPlantaController {

    @Autowired
    CardPlantaRepository repository;
    @Autowired
    NutrientesRepository nutrientesRepository;

    @GetMapping
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Set<CardPlantaResponseDTO>> getAllCards(){

        List<CardPlanta> allCards = repository.findAll();
        Set<CardPlantaResponseDTO> allCardsDTO = new HashSet<>();
        for (CardPlanta card : allCards){
            allCardsDTO.add(CardPlanta.mapToDTO(card));
        }

        return ResponseEntity.ok(allCardsDTO);
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> createCard(@RequestBody @Validated CardPlantaRequestDTO newCardData){
        CardPlanta novoCard = new CardPlanta(newCardData);

        for (NutrientesFavoritos nut : newCardData.nutrientesFavoritos()){
            nut.setCardPlanta(novoCard); //indo na tabela nutrientes setar o card como "dono"
        }

        repository.save(novoCard);
        nutrientesRepository.saveAll(novoCard.getNutrientesFavoritos());
        System.out.println("Finalizando saving do card...");

        return ResponseEntity.ok("Card criado.");
    }
}
