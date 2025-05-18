package br.com.fiap.application.gateway;

public interface VerificaLivroDisponivelGateway {
    boolean verificaDisponibilidade(String livroIsbn);
}
