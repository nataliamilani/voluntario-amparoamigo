package com.amparo.amigo.voluntarioamparoamigo.service;

import com.amparo.amigo.voluntarioamparoamigo.dto.VoluntarioDTO;
import com.amparo.amigo.voluntarioamparoamigo.dto.VoluntarioLoginDTO;
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

    public static Voluntario editarDadosVoluntario(Integer idVoluntario, Voluntario voluntarioEditar) {

        var existeVoluntario = repository.findByIdVoluntario(idVoluntario).isPresent();

        if (!existeVoluntario) {
            throw new VoluntarioNotFoundException("Não existe voluntário cadastrado na base");
        } else {

            var atualizarVoluntario = repository.findByIdVoluntario(idVoluntario).get();

            atualizarVoluntario.setNome(voluntarioEditar.getNome());
            atualizarVoluntario.setDataNascimento(voluntarioEditar.getDataNascimento());
            atualizarVoluntario.setCpfCnpj(voluntarioEditar.getCpfCnpj());
            atualizarVoluntario.setCelular(voluntarioEditar.getCelular());
            atualizarVoluntario.setLogradouro(voluntarioEditar.getLogradouro());
            atualizarVoluntario.setCidade(voluntarioEditar.getCidade());
            atualizarVoluntario.setEstado(voluntarioEditar.getEstado());
            atualizarVoluntario.setTiposervico1(voluntarioEditar.getTiposervico1());
            atualizarVoluntario.setTiposervico2(voluntarioEditar.getTiposervico2());
            atualizarVoluntario.setTiposervico3(voluntarioEditar.getTiposervico3());
            atualizarVoluntario.setCategoria1(voluntarioEditar.getCategoria1());
            atualizarVoluntario.setCategoria2(voluntarioEditar.getCategoria2());
            atualizarVoluntario.setCategoria3(voluntarioEditar.getCategoria3());
            atualizarVoluntario.setDescricao(voluntarioEditar.getDescricao());
            atualizarVoluntario.setEmail(voluntarioEditar.getEmail());
            atualizarVoluntario.setSenha(voluntarioEditar.getSenha());

            return repository.save(atualizarVoluntario);
        }
    }

    public static List<VoluntarioDTO> consultaVoluntarioCategoriasServicos(String categoria, String tiposervico, String estado, String cidade) {

        var consultaVoluntario = repository.findByVoluntarioCategoriaTipoServico(categoria, tiposervico, estado, cidade);

        if(consultaVoluntario.isEmpty()){
            throw new VoluntarioNotFoundException("Não há voluntários na base de cadastro!");
        }

        List<VoluntarioDTO> listVoluntario = new ArrayList<>();

        for (Integer i=0; i < consultaVoluntario.size(); i++){

            listVoluntario.add(VoluntarioDTO.transformaDTO(consultaVoluntario.get(i)));
        }

        return listVoluntario;
    }

    public static VoluntarioLoginDTO validaLogin(String email, String senha) {

        var existeLogin = repository.findByEmailAndSenha(email, senha).isPresent();

        if(!existeLogin){
            throw new VoluntarioNotFoundException("ATENÇÃO! Login ou senha inválidos, tente novamente.");
        }

        var validaLogin = repository.findByEmailAndSenha(email, senha);

        return VoluntarioLoginDTO.transformaLoginDTO(validaLogin, "Acesso permitido");

    }

}
