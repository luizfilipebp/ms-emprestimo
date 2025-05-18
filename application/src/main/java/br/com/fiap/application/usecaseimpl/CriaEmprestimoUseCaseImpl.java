package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.exception.LivroIndisponivelException;
import br.com.fiap.application.exception.LivroNaoEncontradoException;
import br.com.fiap.application.exception.UsuarioNaoEncontradoException;
import br.com.fiap.application.gateway.CriarEmpretimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.usecase.CriaEmprestimoUseCase;
import br.com.fiap.usecase.VerificarLivroDisponivelUseCase;
import br.com.fiap.usecase.VerificarLivroUseCase;
import br.com.fiap.usecase.VerificarUsuarioUseCase;

public class CriaEmprestimoUseCaseImpl implements CriaEmprestimoUseCase {

    private final VerificarUsuarioUseCase verificarUsuarioUseCase;
    private final VerificarLivroUseCase verificarLivroUseCase;
    private final VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase;
    private final CriarEmpretimoGateway criarEmprestimoGateway;

    public CriaEmprestimoUseCaseImpl(VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarLivroUseCase verificarLivroUseCase, VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase, CriarEmpretimoGateway criarEmprestimoGateway) {
        this.verificarUsuarioUseCase = verificarUsuarioUseCase;
        this.verificarLivroUseCase = verificarLivroUseCase;
        this.verificarLivroDisponivelUseCase = verificarLivroDisponivelUseCase;
        this.criarEmprestimoGateway = criarEmprestimoGateway;
    }

    @Override
    public Emprestimo criaEmprestimo(Emprestimo emprestimo) throws Exception {
        // Verifica se o usuario existe
        verificarUsuarioUseCase.verificaUsuario(emprestimo.getUsuarioId()).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario informado não existe"));

        // Verifica se o livro existe
        verificarLivroUseCase.verificaLivro(emprestimo.getLivroIsbn()).orElseThrow(() -> new LivroNaoEncontradoException("Livro informado não existe"));

        // Verifica se o livro está disponível
        if (! verificarLivroDisponivelUseCase.verificaLivroDisponivel(emprestimo.getLivroIsbn())) {
            throw new LivroIndisponivelException("Livro não está disponível para empréstimo");
        }

        return criarEmprestimoGateway.criarEmpretimo(emprestimo);
    }
}
