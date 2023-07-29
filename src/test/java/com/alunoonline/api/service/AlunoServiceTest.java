package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.dtos.AlunoDTO;
import com.alunoonline.api.repository.AlunoRepository;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.IDN;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {


    @Mock
    ModelMapper modelMapper;

    @Mock
    AlunoRepository alunoRepository;

    @InjectMocks
    AlunoService alunoService;

    final long ID_ALUNO = 100l;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void findAll() {
        Aluno aluno = Aluno.builder()
                .email("rodrigo@uol.com.br")
                .nome("Rodrigo Fujioka")
                .curso("Computação")
                .id(ID_ALUNO)
                .build();

        Mockito.when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno));

        List<Aluno> lista = alunoService.findAll();
        Assertions.assertEquals(1, lista.size());
    }


    @Test
    void delete() {
        alunoService.delete(ID_ALUNO);
        Mockito.verify(alunoRepository, Mockito.times(2)).deleteById(ID_ALUNO);
    }


    @Test
    void findById() {
        Assertions.assertEquals(1,2);
    }

    @Test
    void buscarPorId() {
        Assertions.assertEquals(1,2);
    }

    @Test
    void buscarPorNomeIgual() {
        Assertions.assertEquals(1,2);
    }

    @Test
    void buscarPorNomeLike() {
        Assertions.assertEquals(1,2);
    }
}