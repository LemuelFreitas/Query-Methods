package com.ProvaRelacionamentosCritico.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProvaRelacionamentosCritico.Entities.AlunoEntities;
import com.ProvaRelacionamentosCritico.service.AlunoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins="*")
public class AlunoController {

	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/cidade/(cidade)")
	public ResponseEntity<List<AlunoEntities>> buscarAlunosPorCidade (@PathVariable String cidade){
		List<AlunoEntities> alunos = alunoService.buscarAlunosPorCidade(cidade);
		return ResponseEntity.ok(alunos);
	}
	public ResponseEntity<List<AlunoEntities>> buscarAlunosPorCidadeRenda(@PathVariable String cidade, @PathVariable String renda) {
		List<AlunoEntities> Aluno = alunoService.buscarAlunosPorCidadeRenda(cidade, renda);
		return ResponseEntity.ok(Aluno);
	}
	@GetMapping("/{id}")

	public ResponseEntity<AlunoEntities> buscaAlunoControlId(@PathVariable Long id) {
		AlunoEntities Aluno = alunoService.buscaAlunosId(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<AlunoEntities>> buscaTodosAlunoControl() {
		List<AlunoEntities> Aluno = alunoService.buscaTodosAluno();
		return ResponseEntity.ok(Aluno);
	}

	@PostMapping

	public ResponseEntity<AlunoEntities> salvaAlunoControl(@RequestBody @Valid AlunoEntities aluno) {
		AlunoEntities salvaAluno = alunoService.salvaAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}

	@PutMapping("/{id}")

	public ResponseEntity<AlunoEntities> alterarAlunoControl(@PathVariable Long id, @RequestBody @Valid AlunoEntities Aluno) {
		AlunoEntities alterarAluno = alunoService.alterarAluno(id, Aluno);
		if (alterarAluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<AlunoEntities> apagaAlunoControl(@PathVariable Long id) {
		boolean apagar = alunoService.apagarAlunos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}


