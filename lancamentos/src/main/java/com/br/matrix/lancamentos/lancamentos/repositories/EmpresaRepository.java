package com.br.matrix.lancamentos.lancamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matrix.lancamentos.lancamentos.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	//Optional<Empresa> findByNomeOrCnpjIgnoreCaseContainig(String nome);
}
