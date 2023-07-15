package com.alunoonline.api.model.dtos;

import lombok.Data;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private String curso;
}
