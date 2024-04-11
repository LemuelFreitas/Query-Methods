package com.ProvaRelacionamentosCritico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentosCritico.Entities.TurmaEntities;
import com.ProvaRelacionamentosCritico.repository.TurmaRepository;

@Service
public class TurmaService {

	private final TurmaRepository turmaRepository;
	
	@Autowired
	public TurmaService(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	
	public List<TurmaEntities> buscarTurmaPorNome(String nome) {
		return turmaRepository.findByNome(nome);
}
	public List<TurmaEntities> buscarTurmaPorDescricao(String descricao) {
		return turmaRepository.findByDescricao(descricao);
}
	public List<TurmaEntities> buscarTurmaPorNomeDescricao(String nome, String descricao) {
		return turmaRepository.findByNomeAndDescricao(nome,descricao);
}
	
	
	public  List<TurmaEntities> buscaTodosTurma(){
		return turmaRepository.findAll();
	}
	public TurmaEntities buscaTurmasId(Long id) {
		Optional <TurmaEntities> Turmas = turmaRepository.findById(id);
		return Turmas.orElse(null);
	}
	public TurmaEntities salvaTurma(TurmaEntities Turma){
		return turmaRepository.save(Turma);
	}
	public TurmaEntities alterarTurma(Long id, TurmaEntities alterarTurmas) {
		Optional <TurmaEntities> existeTurmas = turmaRepository.findById(id);
		if (existeTurmas.isPresent()) {
			alterarTurmas.setId(id);
			return turmaRepository.save(alterarTurmas);
		}
		return null;
	}
	public boolean apagarTurmas (Long id) {
		Optional <TurmaEntities> existeTurma = turmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
