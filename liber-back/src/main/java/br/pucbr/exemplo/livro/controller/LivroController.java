package br.pucbr.exemplo.livro.controller;

import br.pucbr.exemplo.livro.entity.Livro;
import br.pucbr.exemplo.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping
    public void salvar(@RequestBody Livro livro) {
        livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listar();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable("id") Integer id) {
        return livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id) {
        livroService.excluir(id);
    }
}
