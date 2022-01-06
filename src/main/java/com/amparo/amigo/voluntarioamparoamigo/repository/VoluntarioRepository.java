package com.amparo.amigo.voluntarioamparoamigo.repository;

import com.amparo.amigo.voluntarioamparoamigo.dto.VoluntarioDTO;
import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, String> {

    Optional<Voluntario> findByCpfCnpj(String cpfCnpj);
    //Voluntario findByCpfCnpjV2(String cpfCnpj);
    Optional<Voluntario> findByIdVoluntario(Integer idVoluntario);

    @Override
    List<Voluntario> findAll();
}
