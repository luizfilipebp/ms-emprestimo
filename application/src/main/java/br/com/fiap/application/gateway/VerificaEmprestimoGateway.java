package br.com.fiap.application.gateway;

import br.com.fiap.core.Emprestimo;

import java.util.Optional;

public interface VerificaEmprestimoGateway {

    Optional<Emprestimo> verificaEmprestimo(String usuarioId, String livroIsbn);
}
