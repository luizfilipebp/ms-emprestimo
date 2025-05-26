package br.com.fiap.infrastructure.dto;

public record LivroDTO(
    String isbn,
    String titulo,
    String autor,
    String editora,
    Integer quantidade
) {
}
