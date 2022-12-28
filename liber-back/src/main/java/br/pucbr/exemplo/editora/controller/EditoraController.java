package br.pucbr.exemplo.editora.controller;

import br.pucbr.exemplo.editora.entity.Editora;
import br.pucbr.exemplo.editora.service.EditoraService;
import br.pucbr.exemplo.util.excecao.ExcecaoExemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    EditoraService editoraService;

    @PostMapping
    public void salvar(@RequestBody Editora editora) throws ExcecaoExemplo {
        editoraService.salvar(editora);
    }

    @GetMapping
    public List<Editora> listar() {
        return editoraService.listar();
    }

    @GetMapping("/{id}")
    public Editora buscarPorId(@PathVariable("id") Integer id) throws ExcecaoExemplo{
        return editoraService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id) throws ExcecaoExemplo{
        editoraService.excluir(id);
    }
}
