package com.alunoonline.api.repository;

import com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findAlunoByNome(String nome);

    public Aluno findAlunoByEmail(String email);
    public List<Aluno>
    findAlunoByNomeAndEmail(String nome, String email);

    public List<Aluno> findAllByNomeOrderByNomeAsc(String nome);

    @Query("select u from Aluno u where u.nome=:nome")
    public List<Aluno> buscarPorNome(@Param("nome") String nome);
}
