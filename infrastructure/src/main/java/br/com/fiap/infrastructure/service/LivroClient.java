package br.com.fiap.infrastructure.service;

import br.com.fiap.infrastructure.dto.LivroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-livros")
public interface  LivroClient {
    @GetMapping("api/livros/{isbn}")
    LivroDTO buscarPorIsbn(@PathVariable("isbn") String isbn);
}
