package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.exception.UsuarioNaoEncontradoException;
import br.com.fiap.application.gateway.VerificaUsuarioGateway;
import br.com.fiap.usecase.VerificarUsuarioUseCase;

import java.util.Optional;

public class VerificarUsuarioUseCaseImpl implements VerificarUsuarioUseCase {

    private final VerificaUsuarioGateway verificaUsuarioGateway;

    public VerificarUsuarioUseCaseImpl(VerificaUsuarioGateway verificaUsuarioGateway) {
        this.verificaUsuarioGateway = verificaUsuarioGateway;
    }

    @Override
    public Optional<String> verificaUsuario(String usuarioId) throws Exception {
        return Optional.of(verificaUsuarioGateway.verificaUsuario(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado!")));
    }
}
