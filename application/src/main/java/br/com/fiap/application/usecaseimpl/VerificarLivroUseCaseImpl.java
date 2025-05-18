package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.exception.LivroNaoEncontradoException;
import br.com.fiap.application.gateway.VerificarLivroGateway;
import br.com.fiap.usecase.VerificarLivroUseCase;

import java.util.Optional;

public class VerificarLivroUseCaseImpl implements VerificarLivroUseCase {

    private final VerificarLivroGateway verificarLivroGateway;

    public VerificarLivroUseCaseImpl(VerificarLivroGateway verificarLivroGateway) {
        this.verificarLivroGateway = verificarLivroGateway;
    }

    @Override
    public Optional<String> verificaLivro(String livroId) throws Exception {
        return Optional.of(verificarLivroGateway.verificaLivro(livroId).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado!")));
    }
}
