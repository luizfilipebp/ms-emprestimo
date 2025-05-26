package br.com.fiap.usecase;

import br.com.fiap.core.Emprestimo;

public interface CriarEmprestimoUseCase {
    Emprestimo criaEmprestimo(String usuarioId, String livroIsbn) throws Exception;
}
