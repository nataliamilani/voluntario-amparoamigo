package com.amparo.amigo.voluntarioamparoamigo.dto;

import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class VoluntarioLoginDTO {

    private Integer idVoluntario;
    private String email;
    private String senha;
    private String status;

    @JsonCreator
    public VoluntarioLoginDTO(@JsonProperty("email") String email,
                              @JsonProperty("senha") String senha,
                              @JsonProperty("idVoluntario") Integer idVoluntario,
                              @JsonProperty("status") String status

    ) {
        this.email = email;
        this.senha = senha;
        this.idVoluntario = idVoluntario;
        this.status = status;
    }

    public static VoluntarioLoginDTO transformaLoginDTO(Voluntario voluntario, String status) {
        return new VoluntarioLoginDTO(voluntario.getEmail(), voluntario.getSenha(), voluntario.getIdVoluntario(), status);
    }

    public static VoluntarioLoginDTO transformaLoginDTO(Optional<Voluntario> voluntario, String status) {
        return new VoluntarioLoginDTO(voluntario.get().getEmail(), voluntario.get().getSenha(), voluntario.get().getIdVoluntario(), status);
    }

}
