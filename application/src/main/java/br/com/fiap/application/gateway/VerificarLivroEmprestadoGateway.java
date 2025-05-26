package br.com.fiap.application.gateway;

public interface VerificarLivroEmprestadoGateway {
    boolean verificar(String usuarioId, String livroIsbn);
}
