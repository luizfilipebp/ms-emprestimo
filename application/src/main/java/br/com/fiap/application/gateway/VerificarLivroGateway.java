package br.com.fiap.application.gateway;

import java.util.Optional;

public interface VerificarLivroGateway {
    Optional<String> verificaLivro(String livroIsbn);
}
