package br.com.fiap.infrastructure.service;

import br.com.fiap.application.exception.EmprestimoNaoEncontradoException;
import br.com.fiap.application.gateway.VerificaEmprestimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.infrastructure.entities.EmprestimoEntity;
import br.com.fiap.infrastructure.mapper.EmprestimoMapper;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificaEmprestimoGatewayImpl implements VerificaEmprestimoGateway {

    private final EmprestimoRepository emprestimoRepository;


    @Override
    public Optional<Emprestimo> verificaEmprestimo(String usuarioId, String livroIsbn) {
        EmprestimoEntity emprestimo = emprestimoRepository.findByUsuarioIdAndLivroIsbnAndDataDevolvidoIsNull(usuarioId, livroIsbn).orElseThrow(() -> new EmprestimoNaoEncontradoException("Empréstimo não encontrado"));

        return Optional.ofNullable(EmprestimoMapper.INSTANCE.emprestimoEntityToEmprestimo(emprestimo));
    }
}
