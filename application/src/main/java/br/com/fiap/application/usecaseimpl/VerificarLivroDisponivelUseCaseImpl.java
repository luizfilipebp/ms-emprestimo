package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.VerificaLivroDisponivelGateway;
import br.com.fiap.usecase.VerificarLivroDisponivelUseCase;

public class VerificarLivroDisponivelUseCaseImpl implements VerificarLivroDisponivelUseCase {

    private final VerificaLivroDisponivelGateway verificaLivroDisponivelGateway;

    public VerificarLivroDisponivelUseCaseImpl(VerificaLivroDisponivelGateway verificaLivroDisponivelGateway) {
        this.verificaLivroDisponivelGateway = verificaLivroDisponivelGateway;
    }

    @Override
    public boolean verificaLivroDisponivel(String livroId) throws Exception {
        return verificaLivroDisponivelGateway.verificaDisponibilidade(livroId);
    }
}
