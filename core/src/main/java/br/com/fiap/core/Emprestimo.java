package br.com.fiap.core;

import java.time.LocalDate;

public class Emprestimo {

    private String usuarioId;
    private String livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvido;


    public Emprestimo(String usuarioId, String livroId, LocalDate dataDevolucao) {
        this.usuarioId = usuarioId;
        this.livroId = livroId;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(7);
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getLivroId() {
        return livroId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolvido() {
        return dataDevolvido;
    }

    public void setDataDevolvido(LocalDate dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }
}
