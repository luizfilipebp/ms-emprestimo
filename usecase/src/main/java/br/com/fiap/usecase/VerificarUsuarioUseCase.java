package br.com.fiap.usecase;

import java.util.Optional;

public interface VerificarUsuarioUseCase {
    Optional<String> verificaUsuario(String usuarioId) throws Exception;
}
