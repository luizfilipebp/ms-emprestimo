package br.com.fiap.usecase;

import br.com.fiap.core.Livro;

import java.util.Optional;

public interface VerificarLivroUseCase {
    Optional<Livro> verificaLivro(String livroId) throws Exception;
}
