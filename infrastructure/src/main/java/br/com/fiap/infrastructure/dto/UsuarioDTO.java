package br.com.fiap.infrastructure.dto;

import br.com.fiap.infrastructure.dto.enums.TipoUsuario;

public record UsuarioDTO(
        String email,
        String nome,
        TipoUsuario tipoUsuario,
        boolean ativado
) {
}
