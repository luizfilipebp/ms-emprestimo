package br.com.fiap.usecase;

import java.util.Optional;

public interface VerificarLivroUseCase {
    Optional<String> verificaLivro(String livroId) throws Exception;
}
