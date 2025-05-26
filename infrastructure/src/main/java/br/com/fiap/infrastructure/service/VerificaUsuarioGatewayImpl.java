package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificaUsuarioGateway;
import br.com.fiap.infrastructure.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificaUsuarioGatewayImpl implements VerificaUsuarioGateway {

    private final UsuarioClient usuarioClient;

    @Override
    public Optional<String> verificaUsuario(String usuarioId) throws Exception {
        UsuarioDTO usuarioDTO = usuarioClient.buscarPorEmail(usuarioId);
        if(!usuarioDTO.ativado()){
            throw new Exception("Usuário não está ativo");
        }
        return Optional.ofNullable(usuarioDTO.email());
    }
}
