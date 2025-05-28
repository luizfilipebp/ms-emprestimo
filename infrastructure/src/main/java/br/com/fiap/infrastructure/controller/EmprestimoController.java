package br.com.fiap.infrastructure.controller;


import br.com.fiap.core.Emprestimo;
import br.com.fiap.core.Livro;
import br.com.fiap.core.Page;
import br.com.fiap.infrastructure.dto.LivroDTO;
import br.com.fiap.infrastructure.service.LivroClient;
import br.com.fiap.usecase.CriarEmprestimoUseCase;
import br.com.fiap.usecase.DevolverEmprestimoUseCase;
import br.com.fiap.usecase.PesquisarLivrosDisponiveisUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmprestimoController {

    private final CriarEmprestimoUseCase criarEmprestimoUseCase;
    private final DevolverEmprestimoUseCase devolverEmprestimoUseCase;
    private final PesquisarLivrosDisponiveisUseCase pesquisarLivrosDisponiveisUseCase;

    private final LivroClient livroClient;


    @GetMapping
    public String listarEmprestimos() {
        return "Lista de Empréstimos";
    }


    @GetMapping("livros-disponiveis")
    public ResponseEntity<Page<LivroDTO>> buscarLivro(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) throws Exception {

        Page<Livro> livro = pesquisarLivrosDisponiveisUseCase.pesquisar(titulo, autor, isbn, pageNumber, pageSize);

        List<LivroDTO> livroDTOs = livro.getContent().stream()
                .map(livroEntity -> new LivroDTO(
                        livroEntity.getIsbn(),
                        livroEntity.getTitulo(),
                        livroEntity.getAutor(),
                        livroEntity.getEditora(),
                        livroEntity.getQuantidade()))
                .toList();

        Page<LivroDTO> livroDTOPage = new Page<>(
                livroDTOs,
                livro.getPageNumber(),
                livro.getPageSize(),
                livro.getTotalElements()
        );

        return ResponseEntity.ok(livroDTOPage);
    }

    @PostMapping("emprestar/{usuarioId}/{livroIsbn}")
    public Emprestimo criarEmprestimo(@PathVariable String usuarioId, @PathVariable String livroIsbn) throws Exception {
        return criarEmprestimoUseCase.criaEmprestimo(usuarioId, livroIsbn);
    }

    @PostMapping("devolver/{usuarioId}/{livroIsbn}")
    public void realizarDevolucao(@PathVariable String usuarioId, @PathVariable String livroIsbn) throws Exception {
        devolverEmprestimoUseCase.devolverEmprestimo(usuarioId, livroIsbn);
    }
}
