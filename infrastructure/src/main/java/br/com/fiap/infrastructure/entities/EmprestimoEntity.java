package br.com.fiap.infrastructure.entities;


import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_livro_id")
    private String livroIsbn;

    @Column(name = "emp_usuario_id")
    private String usuarioId;

    @Column(name = "emp_data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "emp_data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "emp_data_devolvido")
    private LocalDate dataDevolvido;
}
