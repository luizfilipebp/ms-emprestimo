package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.CriarEmpretimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.infrastructure.entities.EmprestimoEntity;
import br.com.fiap.infrastructure.mapper.EmprestimoMapper;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarEmpretimoGatewayImpl implements CriarEmpretimoGateway {

    private final EmprestimoRepository emprestimoRepository;

    @Override
    public Emprestimo criarEmpretimo(Emprestimo emprestimo) {
        EmprestimoEntity saved = emprestimoRepository.save(EmprestimoMapper.INSTANCE.emprestimoToEmprestimoEntity(emprestimo));
        return EmprestimoMapper.INSTANCE.emprestimoEntityToEmprestimo(saved);
    }
}
