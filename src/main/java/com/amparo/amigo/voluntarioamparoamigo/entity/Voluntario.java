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

    @JsonCreator
    public Voluntario( @JsonProperty("nome") String nome,
                       @JsonProperty("data_nascimento") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dataNascimento,
                       @JsonProperty("cpf_cnpj") String cpfCnpj,
                       @JsonProperty("celular") String celular,
                       @JsonProperty("logradouro") String logradouro,
                       @JsonProperty("cidade") String cidade,
                       @JsonProperty("estado") String estado,
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
        this.email = email;
        this.senha = senha;
    }

    public Voluntario(){ super(); }



}
