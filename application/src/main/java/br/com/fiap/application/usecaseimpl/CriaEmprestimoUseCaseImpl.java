package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.exception.LivroIndisponivelException;
import br.com.fiap.application.exception.LivroNaoEncontradoException;
import br.com.fiap.application.exception.UsuarioNaoEncontradoException;
import br.com.fiap.application.exception.UsuarioPossuiEmprestimoException;
import br.com.fiap.application.gateway.CriarEmpretimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.usecase.*;

public class CriaEmprestimoUseCaseImpl implements CriarEmprestimoUseCase {

    private final VerificarUsuarioUseCase verificarUsuarioUseCase;
    private final VerificarLivroUseCase verificarLivroUseCase;
    private final VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase;
    private final VerificarLivroEmprestadoUseCase verificarLivroEmprestadoUseCase;
    private final CriarEmpretimoGateway criarEmprestimoGateway;

    public CriaEmprestimoUseCaseImpl(VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarLivroUseCase verificarLivroUseCase, VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase, VerificarLivroEmprestadoUseCase verificarLivroEmprestadoUseCase, CriarEmpretimoGateway criarEmprestimoGateway) {
        this.verificarUsuarioUseCase = verificarUsuarioUseCase;
        this.verificarLivroUseCase = verificarLivroUseCase;
        this.verificarLivroDisponivelUseCase = verificarLivroDisponivelUseCase;
        this.verificarLivroEmprestadoUseCase = verificarLivroEmprestadoUseCase;
        this.criarEmprestimoGateway = criarEmprestimoGateway;
    }

    @Override
    public Emprestimo criaEmprestimo(String usuarioId, String livroIsbn) throws Exception {
        // Verifica se o usuario existe
        verificarUsuarioUseCase.verificaUsuario(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario informado não existe"));

        // Verifica se o livro existe
        verificarLivroUseCase.verificaLivro(livroIsbn).orElseThrow(() -> new LivroNaoEncontradoException("Livro informado não existe"));

        // Verifica se o livro está disponível
        if (! verificarLivroDisponivelUseCase.verificaLivroDisponivel(livroIsbn)) {
            throw new LivroIndisponivelException("Livro não está disponível para empréstimo");
        }

        // Verifica se o usuario já tem esse livro emprestado
        if (verificarLivroEmprestadoUseCase.verificar(usuarioId, livroIsbn)) {
            throw new UsuarioPossuiEmprestimoException("Usuario já possui este livro emprestado");
        }

        return criarEmprestimoGateway.criarEmpretimo(new Emprestimo(usuarioId, livroIsbn));
    }
}
