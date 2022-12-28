package br.pucbr.exemplo.usuario.service;

import br.pucbr.exemplo.usuario.entity.Usuario;
import br.pucbr.exemplo.usuario.repository.UsuarioRepository;
import br.pucbr.exemplo.util.excecao.ExcecaoExemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) throws ExcecaoExemplo {
        if (usuario.getNome() == null || usuario.getNome().equals("") || usuario.getNome().length() > 300) {
            throw new ExcecaoExemplo("ERR001","Os dados do usuário estão incorretos.");
        } else  if (usuario.getNome().length() > 255){
            throw new ExcecaoExemplo("ERR002", "Nome de usuário muito grande!");
        } else if (usuario.getLogin().length() > 50){
            throw new ExcecaoExemplo("ERR003", "Login do usuário muito grande!");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) throws ExcecaoExemplo{
        if (id <= 0){
            throw new ExcecaoExemplo("ERR001","O id do usuário não pode ser menor ou igual a 0!");
        }

        try{
            Usuario user = usuarioRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExcecaoExemplo("ERR002", "Usuario não encontrado!");
        }
        return usuarioRepository.findById(id).get();
    }

    public void excluir(Integer id) throws ExcecaoExemplo{
        if (id <= 0){
            throw new ExcecaoExemplo("ERR001","O id do usuário não pode ser menor ou igual a 0!");
        }
        usuarioRepository.deleteById(id);
    }

}
