package com.amparo.amigo.voluntarioamparoamigo.repository;

import com.amparo.amigo.voluntarioamparoamigo.dto.VoluntarioDTO;
import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, String> {

    Optional<Voluntario> findByCpfCnpj(String cpfCnpj);

    Optional<Voluntario> findByIdVoluntario(Integer idVoluntario);

    @Override
    List<Voluntario> findAll();

    @Query(value = "select * from voluntario " +
            "where (categoria1 = ?1 or categoria2 = ?1 or categoria3 = ?1) " +
            "and (tiposervico1 = ?2 or tiposervico2 = ?2 or tiposervico3 = ?2) " +
            "and estado = ?3 and cidade = ?4", nativeQuery = true)
    List<Voluntario> findByVoluntarioCategoriaTipoServico(String categoria, String tiposervico, String estado, String cidade);
}
