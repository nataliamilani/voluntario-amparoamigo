package com.amparo.amigo.voluntarioamparoamigo.controller;

import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import com.amparo.amigo.voluntarioamparoamigo.service.VoluntarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Voluntario endpoint")
@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping(path = "/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação online";
    }

    @PostMapping
    public Voluntario cadastrarVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioService.cadastrarVoluntario(voluntario);
    }

    //GET PARA CONSULTAR TODOS VOLUNTARIOS
    @GetMapping(value = "/cpf_cnpj/{cpfCnpj}")
    public Optional<Voluntario> consultaVoluntario(@PathVariable("cpfCnpj") String cpfCnpj) {

        return VoluntarioService.consultaVoluntario(cpfCnpj);
    }

    //GET PARA CONSULTAR TODOS VOLUNTARIOS
    @GetMapping(value = "/id/{idVoluntario}")
    public Optional<Voluntario> consultaVoluntarioId(@PathVariable("idVoluntario") Integer idVoluntario) {

        return VoluntarioService.consultaVoluntarioId(idVoluntario);
    }

}
