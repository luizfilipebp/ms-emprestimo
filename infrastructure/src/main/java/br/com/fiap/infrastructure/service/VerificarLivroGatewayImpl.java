package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificarLivroGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificarLivroGatewayImpl implements VerificarLivroGateway {
    @Override
    public Optional<String> verificaLivro(String livroIsbn) {
        return Optional.empty();
    }
}
