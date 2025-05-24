package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.VerificaLivroDisponivelGateway;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificaLivroDisponivelGatewayImpl implements VerificaLivroDisponivelGateway {


    private final EmprestimoRepository emprestimoRepository;


    @Override
    public boolean verificaDisponibilidade(String livroIsbn) {

        int size = emprestimoRepository.findAllByLivroIdAndDataDevolucaoIsNull(livroIsbn).size();


        return false;
    }
}
