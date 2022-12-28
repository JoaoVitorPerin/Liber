package br.pucbr.exemplo.livro.service;

import br.pucbr.exemplo.livro.entity.Livro;
import br.pucbr.exemplo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void salvar(Livro livro) {
        livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).get();
    }

    public void excluir(Integer id) {
        livroRepository.deleteById(id);
    }

}
