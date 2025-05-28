package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.PesquisarLivrosDisponiveisGateway;
import br.com.fiap.core.Livro;
import br.com.fiap.core.Page;
import br.com.fiap.usecase.PesquisarLivrosDisponiveisUseCase;

public class PesquisarLivrosDisponiveisUseCaseImpl implements PesquisarLivrosDisponiveisUseCase {

    private final PesquisarLivrosDisponiveisGateway pesquisarLivrosDisponiveisGateway;

    public PesquisarLivrosDisponiveisUseCaseImpl(PesquisarLivrosDisponiveisGateway pesquisarLivrosDisponiveisGateway) {
        this.pesquisarLivrosDisponiveisGateway = pesquisarLivrosDisponiveisGateway;
    }

    @Override
    public Page<Livro> pesquisar(String nomeLivro, String autor, String isbn, int pageNumber, int pageSize) throws Exception {

        if (nomeLivro == null || autor == null || isbn == null) {
            throw new IllegalArgumentException("Parâmetros de pesquisa não podem ser nulos");
        }

        if (pageNumber < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Número da página deve ser maior ou igual a 0 e tamanho da página deve ser maior que 0");
        }

        if (pageSize > 100) {
            throw new IllegalArgumentException("Tamanho da página não pode ser maior que 100");
        }

        if (pageNumber > pageSize) {
            throw new IllegalArgumentException("Número da página não pode ser maior que o tamanho da página");
        }

        return pesquisarLivrosDisponiveisGateway.pesquisarLivrosDisponiveis(nomeLivro, autor, isbn, pageNumber, pageSize);
    }
}
