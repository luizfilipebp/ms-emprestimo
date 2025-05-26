package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.VerificarLivroEmprestadoGateway;
import br.com.fiap.usecase.VerificarLivroEmprestadoUseCase;

public class VerificarLivroEmprestadoUseCaseImpl implements VerificarLivroEmprestadoUseCase {

    private final VerificarLivroEmprestadoGateway verificarLivroEmprestadoGateway;

    public VerificarLivroEmprestadoUseCaseImpl(VerificarLivroEmprestadoGateway verificarLivroEmprestadoGateway) {
        this.verificarLivroEmprestadoGateway = verificarLivroEmprestadoGateway;
    }

    @Override
    public boolean verificar(String usuarioId, String livroIsbn) {
        return verificarLivroEmprestadoGateway.verificar(usuarioId, livroIsbn);
    }
}
