package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.Emprestimo;
import br.com.fiap.infrastructure.entities.EmprestimoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmprestimoMapper {

    EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);


    EmprestimoEntity emprestimoToEmprestimoEntity(Emprestimo emprestimo);
    Emprestimo emprestimoEntityToEmprestimo(EmprestimoEntity emprestimoEntity);
}
