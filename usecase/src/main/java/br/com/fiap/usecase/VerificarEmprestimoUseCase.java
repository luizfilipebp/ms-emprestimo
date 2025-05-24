package br.com.fiap.usecase;

import br.com.fiap.core.Emprestimo;

import java.util.Optional;

public interface VerificarEmprestimoUseCase {
    Optional<Emprestimo> verificaEmprestimo(String usuarioId, String livroIsbn);
}
