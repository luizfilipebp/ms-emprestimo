package br.com.fiap.infrastructure.controller;


import br.com.fiap.core.Emprestimo;
import br.com.fiap.usecase.CriarEmprestimoUseCase;
import br.com.fiap.usecase.DevolverEmprestimoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprestimos")
@AllArgsConstructor
public class EmprestimoController {

    private final CriarEmprestimoUseCase criarEmprestimoUseCase;
    private final DevolverEmprestimoUseCase devolverEmprestimoUseCase;


    @GetMapping
    public String listarEmprestimos() {
        return "Lista de Empréstimos";
    }

    @PostMapping("/{usuarioId}/{livroIsbn}")
    public Emprestimo criarEmprestimo(@PathVariable String usuarioId, @PathVariable String livroIsbn) throws Exception {
        return criarEmprestimoUseCase.criaEmprestimo(new Emprestimo(usuarioId, livroIsbn));
    }

    @PutMapping("/{usuarioId}/{livroIsbn}")
    public void realizarDevolucao(@PathVariable String usuarioId, @PathVariable String livroIsbn) throws Exception {
        devolverEmprestimoUseCase.devolverEmprestimo(usuarioId, livroIsbn);
    }
}
