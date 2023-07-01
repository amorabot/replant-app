package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.enciclopedia.Enciclopedia;
import br.com.replantapp.replant.domain.enciclopedia.EnciclopediaRepository;
import br.com.replantapp.replant.domain.usuario.Usuario;
import br.com.replantapp.replant.domain.usuario.UsuarioRepository;
import br.com.replantapp.replant.domain.usuario.UsuarioRequestDTO;
import br.com.replantapp.replant.domain.usuario.UsuarioResponseDTO;
import br.com.replantapp.replant.enums.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/testusuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;
    @Autowired
    EnciclopediaRepository enciclopediaRepository;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Set<UsuarioResponseDTO>> getAllUsuarios(){
        List<Usuario> userList = repository.findAll();
        System.out.println("Fetch bem sucedido!!");
//        return ResponseEntity.ok(userList);
        Set<UsuarioResponseDTO> usuarioDTOList = new HashSet<>();
        for (Usuario usuario : userList){
            usuarioDTOList.add(Usuario.mapToDTO(usuario));
        }
        return ResponseEntity.ok(usuarioDTOList);
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> registrerUsuario(@RequestBody @Validated UsuarioRequestDTO newUserData){
//        System.out.println("testando saving da enciclopedia");
        Usuario novoUsuario = new Usuario(newUserData);

        String userEmail = novoUsuario.getEmail();
        Optional<Usuario> userEntry = repository.findByEmail(userEmail);
        if (!userEntry.isEmpty()){
            return ResponseEntity.badRequest().body("Email ja registrado, insira um email valido.");
        }

        Optional<Enciclopedia> enciclopediaEntry = enciclopediaRepository.findById(newUserData.enciclopedia_id());
        if (!enciclopediaEntry.isEmpty()){
            novoUsuario.setEnciclopedia(enciclopediaEntry.get());
        } else {
            novoUsuario.setEnciclopedia(enciclopediaRepository.findById(2).get());
        }

        repository.save(novoUsuario);
        return ResponseEntity.ok("Registro bem sucedido! Novo usuario registrado.");
    }
}
