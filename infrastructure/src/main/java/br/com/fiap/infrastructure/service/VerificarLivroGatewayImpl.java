package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificarLivroGateway;
import br.com.fiap.core.Livro;
import br.com.fiap.infrastructure.dto.LivroDTO;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificarLivroGatewayImpl implements VerificarLivroGateway {

    private final LivroClient livroClient;

    @Override
    public Optional<Livro> verificaLivro(String livroIsbn) {
        LivroDTO livroDTO = livroClient.buscarPorIsbn(livroIsbn);

        if (livroDTO == null) {
            return Optional.empty();
        }

        return Optional.of(new Livro(
                livroDTO.isbn(),
                livroDTO.titulo(),
                livroDTO.autor(),
                livroDTO.editora(),
                livroDTO.quantidade()
        ));
    }
}
