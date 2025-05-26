package br.com.fiap.infrastructure.service;

import br.com.fiap.application.exception.EmprestimoNaoEncontradoException;
import br.com.fiap.application.gateway.DevolverEmprestimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.infrastructure.entities.EmprestimoEntity;
import br.com.fiap.infrastructure.mapper.EmprestimoMapper;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DevolverEmprestimoGatewayImpl implements DevolverEmprestimoGateway {


    private final EmprestimoRepository repository;



    @Override
    public void devolverEmprestimo(Emprestimo emprestimo) throws Exception {
        EmprestimoEntity emprestimoEntity = repository.findByUsuarioIdAndLivroIsbnAndDataDevolvidoIsNull(emprestimo.getUsuarioId(), emprestimo.getLivroIsbn())
                .orElseThrow(() -> new EmprestimoNaoEncontradoException("Empréstimo não encontrado"));

        emprestimoEntity.setDataDevolvido(emprestimo.getDataDevolvido());

        repository.save(emprestimoEntity);
    }
}
