package br.com.fiap.usecase;

public interface DevolverEmprestimoUseCase {
    void devolverEmprestimo(String idUsuario, String livroIsbn) throws Exception;
}
