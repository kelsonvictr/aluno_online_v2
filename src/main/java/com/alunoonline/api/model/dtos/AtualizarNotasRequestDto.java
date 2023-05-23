package com.alunoonline.api.model.dtos;

import lombok.Data;

/*
O que é uma classe DTO?
-> Data Transfer Object: Padrão de Projeto utilizado para transportar dados de um local para outro.
-> Ele é apenas um OBJETO de dados, portanto não costuma ter comportamento próprio (ao contrário dos modelos).
-> Neste exemplo, queremos manipular e ter acesso apenas aos atributos "nota1" e "nota2" do modelo MatriculaAluno.
-> Em resumo: a ideia é agrupar um conjunto de atributos em uma classe simples para otimizar a comunicação.
-> É uma classe que fornece apenas os atributos necessários em um determinado processo.
*/
@Data
public class AtualizarNotasRequestDto {
    private Double nota1;
    private Double nota2;
}
