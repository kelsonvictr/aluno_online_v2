package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno) {

        return repository.save(aluno);
    }

    public Page<Aluno> listarAlunoPaginado(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable);
    }


    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Aluno> buscarPorNomeIgual(String nome){
        return repository.buscarPorNome(nome);
    }

    public List<Aluno> buscarPorNomeLike(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

}
