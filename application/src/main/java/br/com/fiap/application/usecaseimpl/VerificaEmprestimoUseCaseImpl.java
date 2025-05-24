package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.VerificaEmprestimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.usecase.VerificarEmprestimoUseCase;

import java.util.Optional;

public class VerificaEmprestimoUseCaseImpl implements VerificarEmprestimoUseCase {

    private final VerificaEmprestimoGateway verificaEmprestimoGateway;

    public VerificaEmprestimoUseCaseImpl(VerificaEmprestimoGateway verificaEmprestimoGateway) {
        this.verificaEmprestimoGateway = verificaEmprestimoGateway;
    }


    @Override
    public Optional<Emprestimo> verificaEmprestimo(String usuarioId, String livroIsbn) {
        return verificaEmprestimoGateway.verificaEmprestimo(usuarioId, livroIsbn);
    }
}
