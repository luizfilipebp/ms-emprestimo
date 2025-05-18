package br.com.fiap.application.gateway;

import java.util.Optional;

public interface VerificaUsuarioGateway {
    Optional<String> verificaUsuario(String usuarioId) throws Exception;
}
