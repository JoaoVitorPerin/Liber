package br.pucbr.exemplo.editora.service;

import br.pucbr.exemplo.editora.entity.Editora;
import br.pucbr.exemplo.editora.repository.EditoraRepository;
import br.pucbr.exemplo.util.excecao.ExcecaoExemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public void salvar(Editora editora) throws ExcecaoExemplo{
        if (editora.getNome() == null || editora.getNome().equals("") || editora.getNome().length() > 300) {
            throw new ExcecaoExemplo("ERR001","Os dados da editora estão incorretos!");
        } else  if (editora.getEmail() == null){
            throw new ExcecaoExemplo("ERR002", "Email da editora incorreto!");
        }
        editoraRepository.save(editora);
    }

    public List<Editora> listar() {
        return editoraRepository.findAll();
    }

    public Editora buscarPorId(Integer id) throws ExcecaoExemplo{
        if (id <= 0){
            throw new ExcecaoExemplo("ERR001","O id da editora não pode ser menor ou igual a 0!");
        }

        try{
            Editora editora = editoraRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExcecaoExemplo("ERR002", "Editora não encontrada!");
        }
        return editoraRepository.findById(id).get();
    }

    public void excluir(Integer id) throws ExcecaoExemplo{
        if (id <= 0){
            throw new ExcecaoExemplo("ERR001","O id da editora não pode ser menor ou igual a 0!");
        }
        editoraRepository.deleteById(id);
    }

}
