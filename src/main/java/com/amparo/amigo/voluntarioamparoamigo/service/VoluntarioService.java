package com.amparo.amigo.voluntarioamparoamigo.service;

import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import com.amparo.amigo.voluntarioamparoamigo.exceptions.VoluntarioNotFoundException;
import com.amparo.amigo.voluntarioamparoamigo.repository.VoluntarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VoluntarioService {

    private static VoluntarioRepository repository;
    public VoluntarioService(VoluntarioRepository repository) {
        this.repository = repository;
    }

    public Voluntario cadastrarVoluntario(Voluntario voluntario) {
        var cadastrarVoluntario = repository.findByCpfCnpj(voluntario.getCpfCnpj()).isPresent();

        if(cadastrarVoluntario){
            throw new VoluntarioNotFoundException("Voluntário já existente na base de cadastro. CPF: " + voluntario.getCpfCnpj() + " Nome: " + voluntario.getNome());
        }

        return repository.save(voluntario);
    }

    public static Optional<Voluntario> consultaVoluntario(String cpfCnpj) {

        var consultaVoluntario = repository.findByCpfCnpj(cpfCnpj).isPresent();

        if(!consultaVoluntario){
            throw new VoluntarioNotFoundException("Voluntário não encontrado na base de cadastro!");
        }

        return repository.findByCpfCnpj(cpfCnpj);
    }
}
