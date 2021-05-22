package br.com.wkagencia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wkagencia.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long>{

    List<Candidato> findByEstado(String estado);

    List<Candidato> findByTipoSanguineo(String tipoSanguineo);

    // @Query(name = "select * from Candidato where dataNasc >= :from and dataNasc <= :to", nativeQuery = true)
    List<Candidato> findByDataNascBetween(LocalDate de, LocalDate ate);

    List<Candidato> findBySexo(String sexo);
}
