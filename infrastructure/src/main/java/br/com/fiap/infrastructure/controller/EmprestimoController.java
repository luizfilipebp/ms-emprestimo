package br.com.fiap.infrastructure.controller;


import br.com.fiap.core.Emprestimo;
import br.com.fiap.infrastructure.dto.LivroDTO;
import br.com.fiap.infrastructure.service.LivroClient;
import br.com.fiap.usecase.CriarEmprestimoUseCase;
import br.com.fiap.usecase.DevolverEmprestimoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmprestimoController {

    private final CriarEmprestimoUseCase criarEmprestimoUseCase;
    private final DevolverEmprestimoUseCase devolverEmprestimoUseCase;

    private final LivroClient livroClient;


    @GetMapping
    public String listarEmprestimos() {
        return "Lista de Empréstimos";
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
