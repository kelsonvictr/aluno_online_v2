package com.alunoonline.api.controller;

import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.model.dtos.AtualizarNotasRequestDto;
import com.alunoonline.api.model.dtos.HistoricoAlunoDto;
import com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> create(@RequestBody MatriculaAluno matriculaAluno) {
        MatriculaAluno matriculaAlunoCreated = service.create(matriculaAluno);

        return ResponseEntity.status(201).body(matriculaAlunoCreated);
    }

    @PatchMapping("/update-grades/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaNotas(@RequestBody AtualizarNotasRequestDto atualizarNotasRequestDto,
                      @PathVariable Long id) {
        service.updateGrades(atualizarNotasRequestDto, id);
    }

    @PatchMapping("/atualiza-status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaStatus(@PathVariable Long id) throws Exception {
        service.updateStatusToBreak(id);
    }

    @GetMapping("/historico-aluno/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoDto getHistoricoDoAluno(@PathVariable Long id) {
        return service.getHistoricoFromAluno(id);
    }
}
