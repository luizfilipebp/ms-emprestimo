package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificarLivroEmprestadoGateway;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificarLivroEmprestadoGatewayImpl implements VerificarLivroEmprestadoGateway {

    private final EmprestimoRepository emprestimoRepository;

    @Override
    public boolean verificar(String usuarioId, String livroIsbn) {
        return !emprestimoRepository.findByUsuarioIdAndLivroIsbnAndDataDevolvidoIsNull(usuarioId, livroIsbn).isEmpty();
    }
}
