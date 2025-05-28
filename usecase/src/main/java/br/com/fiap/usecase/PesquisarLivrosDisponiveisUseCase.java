package br.com.fiap.usecase;

import br.com.fiap.core.Livro;
import br.com.fiap.core.Page;

public interface PesquisarLivrosDisponiveisUseCase {
    Page<Livro> pesquisar(String nomeLivro, String autor, String isbn, int pageNumber, int pageSize) throws Exception;
}
