package com.alunoonline.api.model.dtos;

import com.alunoonline.api.model.Aluno;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Data
public class AlunoNomeCursoDTO {

    private String nome;
    private String curso;
    public AlunoNomeCursoDTO(@NotNull Aluno aluno){
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
    }
}
