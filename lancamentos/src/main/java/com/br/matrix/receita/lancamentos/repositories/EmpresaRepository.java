package com.br.matrix.receita.lancamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matrix.receita.lancamentos.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Optional <Empresa> findById(Long id);
	Optional <Empresa> findByNomeAndCnpj(String nome, String cnpj);
}
