package com.amparo.amigo.voluntarioamparoamigo.service;

import com.amparo.amigo.voluntarioamparoamigo.dto.VoluntarioDTO;
import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import com.amparo.amigo.voluntarioamparoamigo.exceptions.VoluntarioNotFoundException;
import com.amparo.amigo.voluntarioamparoamigo.repository.VoluntarioRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public static VoluntarioDTO consultaVoluntario(String cpfCnpj) {

        var consultaVoluntario = repository.findByCpfCnpj(cpfCnpj).isPresent();

        if(!consultaVoluntario){
            throw new VoluntarioNotFoundException("Voluntário não encontrado na base de cadastro!");
        }

        return VoluntarioDTO.transformaDTO(repository.findByCpfCnpj(cpfCnpj));
    }

    public static VoluntarioDTO consultaVoluntarioId(Integer idVoluntario) {

        var consultaVoluntarioId = repository.findByIdVoluntario(idVoluntario).isPresent();

        if(!consultaVoluntarioId){
            throw new VoluntarioNotFoundException("Voluntário não encontrado na base de cadastro!");
        }

        return VoluntarioDTO.transformaDTO(repository.findByIdVoluntario(idVoluntario));
    }

    public static List<VoluntarioDTO> consultaTodosVoluntarios() {

        var consultaVoluntarios = repository.findAll();

        if(consultaVoluntarios.isEmpty()){
            throw new VoluntarioNotFoundException("Não há voluntários na base de cadastro!");
        }

        List<VoluntarioDTO> listVoluntario = new ArrayList<>();

        for (Integer i=0; i < consultaVoluntarios.size(); i++){

            listVoluntario.add(VoluntarioDTO.transformaDTO(consultaVoluntarios.get(i)));
        }

        return listVoluntario;
    }




}
