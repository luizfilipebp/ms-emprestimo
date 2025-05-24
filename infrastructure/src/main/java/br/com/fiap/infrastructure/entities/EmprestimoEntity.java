package br.com.fiap.infrastructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprestimo")
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoEntity {
    @Id
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_livro_id")
    private String livroId;

    @Column(name = "emp_usuario_id")
    private String usuarioId;

    @Column(name = "emp_data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "emp_data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "emp_data_devolvido")
    private LocalDate dataDevolvido;
}
