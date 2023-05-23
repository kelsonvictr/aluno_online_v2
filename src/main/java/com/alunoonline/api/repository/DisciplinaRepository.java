package com.alunoonline.api.repository;

import com.alunoonline.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByProfessorId(Long professorId);
}
