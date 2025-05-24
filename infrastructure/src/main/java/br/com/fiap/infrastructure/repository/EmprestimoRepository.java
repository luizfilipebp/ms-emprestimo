package br.com.fiap.infrastructure.repository;

import br.com.fiap.infrastructure.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    Optional<EmprestimoEntity> findByIdUsuarioAndLivroId(String idUsuario, String livroId);
    List<EmprestimoEntity> findAllByLivroIdAndDataDevolucaoIsNull(String livroId);
}
