package br.com.fiap.usecase;

/**
 * Interface para verificar se um usuario possui um livro emprestado.
 */
public interface VerificarLivroEmprestadoUseCase {
    boolean verificar(String usuarioId, String livroIsbn);
}
