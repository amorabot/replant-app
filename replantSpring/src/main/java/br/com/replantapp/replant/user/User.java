package br.com.replantapp.replant.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private String url;

    public User(UserRequestDTO userData){//criar um usuário com dados vindo do request do cliente
        // não precisamos criar o ID, é automático
        name = userData.name();
        region = userData.region();
        url = userData.url();
    }
}
