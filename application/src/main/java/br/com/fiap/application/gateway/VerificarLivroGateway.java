package br.com.fiap.application.gateway;

import br.com.fiap.core.Livro;

import java.util.Optional;

public interface VerificarLivroGateway {
    Optional<Livro> verificaLivro(String livroIsbn);
}
