package br.com.replantapp.replant.controller;

import br.com.replantapp.replant.user.User;
import br.com.replantapp.replant.user.UserRepository;
import br.com.replantapp.replant.user.UserRequestDTO;
import br.com.replantapp.replant.user.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //gera um bean do spring indicando que essa classe é um controller MVC
@RequestMapping("users") //Argumento define o endpoint que essa classe irá ser responsável, tudo que bater em root/users será tratado aqui
public class UserController {

    @Autowired //Autowired já indica pro spring criar sozinho uma classe que implementa a interface e inxertar na variável userRepository
    //ele faz isso automaticamente e deixa pronto pra usar
    private UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*") //em ambiente de produção, "*" vira "dominioDaAplicação", está aberto p/ tudo p/ testes
    @PostMapping
    public void saveUser(@RequestBody UserRequestDTO data){
        User userData = new User(data);
        userRepository.save(userData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> userList = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        return userList;
    }
}
