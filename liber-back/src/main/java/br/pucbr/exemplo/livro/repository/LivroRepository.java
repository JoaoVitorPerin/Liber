package br.pucbr.exemplo.livro.repository;

import br.pucbr.exemplo.livro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Integer> {
}
