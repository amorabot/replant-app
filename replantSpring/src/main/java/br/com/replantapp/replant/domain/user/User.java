package br.com.replantapp.replant.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "users")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
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


