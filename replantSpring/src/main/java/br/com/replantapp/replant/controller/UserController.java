package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.domain.user.User;
import br.com.replantapp.replant.domain.user.UserRepository;
import br.com.replantapp.replant.domain.user.UserRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Indica que é um controller MVC, irá rotear os verbos HTTP para suas devidas funcionalidades, pra isso cria um Bean do Spring que será gerido
@RequestMapping("/users")
/*
 * Todos os requests que chegarem para .../users serão tratados aqui. É onde declaramos a URL que esse controller irá se responsabilizar
 * Existem outros mappings, como Post, Delete, Put... mas esses são as formas de tratar os verbos HTTP
 */
public class UserController {

    @Autowired // Nos ajuda a indicar para o spring que características desejamos que ele lide automaticamente. Nesse caso, todas as
    //Funcionalidades de UserRepository estarão disponíveis para uso em runtime, mesmo sendo apenas uma interface

    private UserRepository userRepository; //UserRepository nos permite fazer alterações no respositório indicado(User) com facilidade

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody @Validated UserRequestDTO newUserData){ //O Spring ja mapeia e valida o request para o DTO
        User newUser = new User(newUserData);
        userRepository.save(newUser);
        return ResponseEntity.ok("Registro bem-sucedido!");
    }
    @PutMapping
    @Transactional
    public ResponseEntity<User> updateUser(@RequestBody @Validated UserRequestDTO updatedUserData){
        if (updatedUserData.id()==null || updatedUserData.id().equals("")) {
            return ResponseEntity.badRequest().build();
        }
        Optional<User> fetchedUser = userRepository.findById(updatedUserData.id());
        if (fetchedUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User user = fetchedUser.get(); //Pela annotation @Transactional, podemos fazer mudanças na entidade serem refletidas na tabela original em runtime
        user.setName(updatedUserData.name());
        user.setRegion(updatedUserData.region());
        user.setUrl(updatedUserData.url());
        return ResponseEntity.ok(user); //Aqui são refletidas as mudanças no objeto user (e na tabela que é representada!)
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping
//    public List<UserResponseDTO> getAllUsers(){
//        List<UserResponseDTO> userList = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
//        return userList;
//    }
//    @CrossOrigin(origins = "*", allowedHeaders = "*") //em ambiente de produção, "*" vira "dominioDaAplicação", está aberto p/ tudo p/ testes
//    @PostMapping
//    public void saveUser(@RequestBody UserRequestDTO data){
//        User userData = new User(data);
//        userRepository.save(userData);
//    }
}
