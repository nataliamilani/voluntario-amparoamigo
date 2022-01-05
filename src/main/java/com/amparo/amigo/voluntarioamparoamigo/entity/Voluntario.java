package com.amparo.amigo.voluntarioamparoamigo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "voluntario")
@Setter
@Getter
public class Voluntario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Integer idVoluntario;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    @Column(name = "senha")
    private String senha;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tiposervico1")
    private String tiposervico1;

    @Column(name = "tiposervico2")
    private String tiposervico2;

    @Column(name = "tiposervico3")
    private String tiposervico3;

    @Column(name = "categoria1")
    private String categoria1;

    @Column(name = "categoria2")
    private String categoria2;

    @Column(name = "categoria3")
    private String categoria3;

    @Column(name = "descricao")
    private String descricao;

    @JsonCreator
    public Voluntario( @JsonProperty("nomeCompleto") String nome,
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
                       @JsonProperty("email") String email,
                       @JsonProperty("senha") String senha
                       )
    {
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
        this.email = email;
        this.senha = senha;
    }

    public Voluntario(){ super(); }

}
