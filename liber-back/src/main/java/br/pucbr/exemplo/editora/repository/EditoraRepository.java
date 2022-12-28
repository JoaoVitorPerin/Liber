package br.pucbr.exemplo.editora.repository;

import br.pucbr.exemplo.editora.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora,Integer> {
}
