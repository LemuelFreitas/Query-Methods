package com.ProvaRelacionamentosCritico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentosCritico.Entities.TurmaEntities;

public interface TurmaRepository extends JpaRepository<TurmaEntities,Long> {
	List<TurmaEntities> findByNome(String nome);
	List<TurmaEntities> findByDescricao(String decricao);
	List<TurmaEntities> findByNomeAndDescricao(String nome, String descricao);
}
