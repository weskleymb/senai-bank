package br.senai.rn.senaibank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

//    @Column(name = "data_nascimento")
//    @Temporal(TemporalType.DATE)
//    private Date dataNascimento;

}
