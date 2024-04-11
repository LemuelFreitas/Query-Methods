package com.ProvaRelacionamentosCritico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentosCritico.Entities.AlunoEntities;

	public interface AlunoRepository extends JpaRepository<AlunoEntities, Long>{
		List<AlunoEntities> findByCidade(String cidade);
		List<AlunoEntities> findByRenda(String renda);
		List<AlunoEntities> findByRa(String ra);
		List<AlunoEntities> findByCidadeAndRenda(String cidade,String renda);
	}

