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

import com.ProvaRelacionamentosCritico.Entities.TurmaEntities;
import com.ProvaRelacionamentosCritico.service.TurmaService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/turma")
@CrossOrigin(origins="*")
public class TurmaController {

	private final TurmaService turmaService;

	@Autowired
	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<TurmaEntities> buscaTurmaControlId(@PathVariable Long id) {
		TurmaEntities Turma = turmaService.buscaTurmasId(id);
		if (Turma != null) {
			return ResponseEntity.ok(Turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/nome/{nome}/descricao/{descricao}")

	public ResponseEntity<List<TurmaEntities>> buscarTurmaPorNomeDescricao(@PathVariable String nome, @PathVariable String descricao) {
		List<TurmaEntities> Turma = turmaService.buscarTurmaPorNomeDescricao(nome, descricao);
		return ResponseEntity.ok(Turma);
	}
	
	@GetMapping

	public ResponseEntity<List<TurmaEntities>> buscaTodosTurmaControl() {
		List<TurmaEntities> Turma = turmaService.buscaTodosTurma();
		return ResponseEntity.ok(Turma);
	}

	@PostMapping

	public ResponseEntity<TurmaEntities> salvaTurmaControl(@RequestBody @Valid TurmaEntities turma) {
		TurmaEntities salvaTurma = turmaService.salvaTurma(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}

	@PutMapping("/{id}")

	public ResponseEntity<TurmaEntities> alterarTurmaControl(@PathVariable Long id, @RequestBody @Valid TurmaEntities Turma) {
		TurmaEntities alterarTurma = turmaService.alterarTurma(id, Turma);
		if (alterarTurma != null) {
			return ResponseEntity.ok(Turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<TurmaEntities> apagaTurmaControl(@PathVariable Long id) {
		boolean apagar = turmaService.apagarTurmas(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

