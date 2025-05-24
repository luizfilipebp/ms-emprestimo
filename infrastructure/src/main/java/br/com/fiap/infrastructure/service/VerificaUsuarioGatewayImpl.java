package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificaUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificaUsuarioGatewayImpl implements VerificaUsuarioGateway {

    @Override
    public Optional<String> verificaUsuario(String usuarioId) throws Exception {
        return Optional.empty();
    }
}
