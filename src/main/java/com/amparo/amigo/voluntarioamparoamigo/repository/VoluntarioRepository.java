package com.amparo.amigo.voluntarioamparoamigo.repository;

import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, String> {

    Optional<Voluntario> findByCpfCnpj(String cpfCnpj);

}
