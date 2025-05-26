package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificaLivroDisponivelGateway;
import br.com.fiap.core.Livro;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import br.com.fiap.usecase.VerificarLivroUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificaLivroDisponivelGatewayImpl implements VerificaLivroDisponivelGateway {


    private final EmprestimoRepository emprestimoRepository;

    private final VerificarLivroUseCase verificarLivroUseCase;


    @Override
    public boolean verificaDisponibilidade(String livroIsbn) throws Exception {

        Livro livro = verificarLivroUseCase.verificaLivro(livroIsbn).orElseThrow(() -> new Exception("Livro não encontrado"));

        int size = emprestimoRepository.findAllByLivroIsbnAndDataDevolvidoIsNull(livroIsbn).size();

        return (livro.getQuantidade() > size);
    }
}
