package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.PesquisarLivrosDisponiveisGateway;
import br.com.fiap.core.Livro;
import br.com.fiap.core.Page;
import br.com.fiap.infrastructure.dto.LivroDTO;
import br.com.fiap.infrastructure.repository.EmprestimoRepository;
import br.com.fiap.usecase.VerificarLivroDisponivelUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PesquisarLivrosDisponiveisUseCaseImpl implements PesquisarLivrosDisponiveisGateway {

    private final EmprestimoRepository emprestimoRepository;

    private final VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase;

    private final LivroClient livroClient;


    @Override
    public Page<Livro> pesquisarLivrosDisponiveis(String nomeLivro, String autor, String isbn, int pageNumber, int pageSize) throws Exception {

        List<LivroDTO> livrosEncontrados = new ArrayList<>();


        if (isbn != null && !isbn.isEmpty()) {
            LivroDTO livroDTO = livroClient.buscarPorIsbn(isbn);
            if (verificarLivroDisponivelUseCase.verificaLivroDisponivel(livroDTO.isbn())) {
                livrosEncontrados.add(livroDTO);
            }
        }

        if (autor != null && !autor.isEmpty()) {
            List<LivroDTO> livrosPorAutor = livroClient.buscarPorAutor(autor);
            for (LivroDTO livroDTO : livrosPorAutor) {
                if (verificarLivroDisponivelUseCase.verificaLivroDisponivel(livroDTO.isbn())) {
                    livrosEncontrados.add(livroDTO);
                }
            }
        }

        if (nomeLivro != null && !nomeLivro.isEmpty()) {
            List<LivroDTO> livrosPorTitulo = livroClient.buscarPorTitulo(nomeLivro);
            for (LivroDTO livroDTO : livrosPorTitulo) {
                if (verificarLivroDisponivelUseCase.verificaLivroDisponivel(livroDTO.isbn())) {
                    livrosEncontrados.add(livroDTO);
                }
            }
        }

     return new Page<>(
             livrosEncontrados.stream()
                     .skip((long) pageNumber * pageSize)
                     .limit(pageSize)
                     .map(dto -> new Livro(dto.isbn(), dto.titulo(), dto.autor(), "", 0))
                     .collect(Collectors.toList()),
             pageNumber,
             pageSize,
             livrosEncontrados.size()
     );
    }
}
