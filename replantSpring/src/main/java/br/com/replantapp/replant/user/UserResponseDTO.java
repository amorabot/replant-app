package br.com.replantapp.replant.user;

// DTO - Data Transfer Object
// Serve para não trabalharmos diretamente com as entidades que representam a tabela User
public record UserResponseDTO(Long id, String name, String region, String url) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getRegion(), user.getUrl());
    }
}
