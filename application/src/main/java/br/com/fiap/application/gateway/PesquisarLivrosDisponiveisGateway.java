package br.com.fiap.application.gateway;

import br.com.fiap.core.Livro;
import br.com.fiap.core.Page;

public interface PesquisarLivrosDisponiveisGateway {

    Page<Livro> pesquisarLivrosDisponiveis(String nomeLivro, String autor, String isbn, int pageNumber, int pageSize) throws Exception;
}
