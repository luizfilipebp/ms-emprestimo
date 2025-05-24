package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.exception.EmprestimoNaoEncontradoException;
import br.com.fiap.application.exception.LivroNaoEncontradoException;
import br.com.fiap.application.exception.UsuarioNaoEncontradoException;
import br.com.fiap.application.gateway.DevolverEmprestimoGateway;
import br.com.fiap.core.Emprestimo;
import br.com.fiap.usecase.DevolverEmprestimoUseCase;
import br.com.fiap.usecase.VerificarEmprestimoUseCase;
import br.com.fiap.usecase.VerificarLivroUseCase;
import br.com.fiap.usecase.VerificarUsuarioUseCase;

public class DevolverEmprestimoUseCaseImpl implements DevolverEmprestimoUseCase {

    private final VerificarUsuarioUseCase verificarUsuarioUseCase;
    private final VerificarLivroUseCase verificarLivroUseCase;
    private final VerificarEmprestimoUseCase verificarEmprestimoUseCase;
    private final DevolverEmprestimoGateway devolverEmprestimoGateway;

    public DevolverEmprestimoUseCaseImpl(VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarLivroUseCase verificarLivroUseCase, VerificarEmprestimoUseCase verificarEmprestimoUseCase, DevolverEmprestimoGateway devolverEmprestimoGateway) {
        this.verificarUsuarioUseCase = verificarUsuarioUseCase;
        this.verificarLivroUseCase = verificarLivroUseCase;
        this.verificarEmprestimoUseCase = verificarEmprestimoUseCase;
        this.devolverEmprestimoGateway = devolverEmprestimoGateway;
    }

    @Override
    public void devolverEmprestimo(String idUsuario, String livroIsbn) throws Exception {
        verificarUsuarioUseCase.verificaUsuario(idUsuario).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado!"));
        verificarLivroUseCase.verificaLivro(livroIsbn).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado!"));

        Emprestimo emprestimo = verificarEmprestimoUseCase.verificaEmprestimo(idUsuario, livroIsbn).orElseThrow(() -> new EmprestimoNaoEncontradoException("Empréstimo não encontrado!"));

        emprestimo.devolver();

        // Aqui você pode adicionar a lógica para atualizar o status do empréstimo no banco de dados ou em outro repositório

        devolverEmprestimoGateway.devolverEmprestimo(emprestimo);
    }
}
