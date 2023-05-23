package com.alunoonline.api.model.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {

    private String nomeAluno;
    private String cursoAluno;
    private List<DisciplinasAlunoDto> disciplinasAlunoList;
}