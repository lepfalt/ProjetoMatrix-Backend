package com.br.matrix.receita.lancamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matrix.receita.lancamentos.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional <Categoria> findByDescricao(String descricao);
}
