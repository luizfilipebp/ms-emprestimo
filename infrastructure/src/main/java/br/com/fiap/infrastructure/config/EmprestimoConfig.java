package br.com.fiap.infrastructure.config;

import br.com.fiap.application.gateway.*;
import br.com.fiap.application.usecaseimpl.*;
import br.com.fiap.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmprestimoConfig {

    @Bean
    VerificarEmprestimoUseCase verificarEmprestimoUseCase(VerificaEmprestimoGateway verificaEmprestimoGateway ){
        return new VerificaEmprestimoUseCaseImpl(verificaEmprestimoGateway);
    }

    @Bean
    DevolverEmprestimoUseCase devolverEmprestimoUseCase(VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarLivroUseCase verificarLivroUseCase, VerificarEmprestimoUseCase verificarEmprestimoUseCase, DevolverEmprestimoGateway devolverEmprestimoGateway ){
        return new DevolverEmprestimoUseCaseImpl(verificarUsuarioUseCase, verificarLivroUseCase, verificarEmprestimoUseCase, devolverEmprestimoGateway);
    }

    @Bean
    VerificarUsuarioUseCase verificarUsuarioUseCase(VerificaUsuarioGateway verificaUsuarioGateway){
        return new VerificarUsuarioUseCaseImpl(verificaUsuarioGateway);
    }

    @Bean
    VerificarLivroUseCase verificarLivroUseCase(VerificarLivroGateway verificarLivroGateway){
        return new VerificarLivroUseCaseImpl(verificarLivroGateway);
    }

    @Bean
    VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase(VerificaLivroDisponivelGateway verificaLivroDisponivelGateway) {
        return new VerificarLivroDisponivelUseCaseImpl(verificaLivroDisponivelGateway);
    }

    @Bean
    CriarEmprestimoUseCase criarEmprestimoUseCase(VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarLivroUseCase verificarLivroUseCase, VerificarLivroDisponivelUseCase verificarLivroDisponivelUseCase, CriarEmpretimoGateway criarEmprestimoGateway){
        return new CriaEmprestimoUseCaseImpl(verificarUsuarioUseCase, verificarLivroUseCase, verificarLivroDisponivelUseCase, criarEmprestimoGateway);
    }
}
