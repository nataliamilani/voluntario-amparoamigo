package com.amparo.amigo.voluntarioamparoamigo.dto;

import com.amparo.amigo.voluntarioamparoamigo.entity.Voluntario;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class VoluntarioDTO {

    private Integer idVoluntario;
    private String cpfCnpj;
    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String celular;
    private String logradouro;
    private String cidade;
    private String estado;
    private String tiposervico1;
    private String tiposervico2;
    private String tiposervico3;
    private String categoria1;
    private String categoria2;
    private String categoria3;
    private String descricao;

    @JsonCreator
    public VoluntarioDTO(@JsonProperty("nomeCompleto") String nome,
                         @JsonProperty("dataNascimento") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dataNascimento,
                         @JsonProperty("cpfCnpj") String cpfCnpj,
                         @JsonProperty("telefoneCelular") String celular,
                         @JsonProperty("endereco") String logradouro,
                         @JsonProperty("cidade") String cidade,
                         @JsonProperty("estado") String estado,
                         @JsonProperty("tipoServico1") String tiposervico1,
                         @JsonProperty("tipoServico2") String tiposervico2,
                         @JsonProperty("tipoServico3") String tiposervico3,
                         @JsonProperty("categoria1") String categoria1,
                         @JsonProperty("categoria2") String categoria2,
                         @JsonProperty("categoria3") String categoria3,
                         @JsonProperty("descricao") String descricao,
                         @JsonProperty("idVoluntario") Integer idVoluntario

    ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpfCnpj = cpfCnpj;
        this.celular = celular;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.tiposervico1 = tiposervico1;
        this.tiposervico2 = tiposervico2;
        this.tiposervico3 = tiposervico3;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.categoria3 = categoria3;
        this.descricao = descricao;
        this.idVoluntario = idVoluntario;
    }

    public static VoluntarioDTO transformaDTO(Voluntario voluntario) {
        return new VoluntarioDTO(voluntario.getNome(), voluntario.getDataNascimento(), voluntario.getCpfCnpj(), voluntario.getCelular(), voluntario.getLogradouro(), voluntario.getCidade(), voluntario.getEstado(), voluntario.getTiposervico1(), voluntario.getTiposervico2(), voluntario.getTiposervico3(), voluntario.getCategoria1(), voluntario.getCategoria2(), voluntario.getCategoria3(), voluntario.getDescricao(), voluntario.getIdVoluntario());
    }

    public static VoluntarioDTO transformaDTO(Optional<Voluntario> voluntario) {
        return new VoluntarioDTO(voluntario.get().getNome(), voluntario.get().getDataNascimento(), voluntario.get().getCpfCnpj(), voluntario.get().getCelular(), voluntario.get().getLogradouro(), voluntario.get().getCidade(), voluntario.get().getEstado(), voluntario.get().getTiposervico1(), voluntario.get().getTiposervico2(), voluntario.get().getTiposervico3(), voluntario.get().getCategoria1(), voluntario.get().getCategoria2(), voluntario.get().getCategoria3(), voluntario.get().getDescricao(), voluntario.get().getIdVoluntario());
    }
}
