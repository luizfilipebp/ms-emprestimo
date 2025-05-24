package br.com.fiap.application.gateway;

import br.com.fiap.core.Emprestimo;

public interface DevolverEmprestimoGateway {
    void devolverEmprestimo(Emprestimo emprestimo) throws Exception;
}
