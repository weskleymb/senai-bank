package br.senai.rn.senaibank.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Conta extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long agencia;

    @JoinColumn(name = "id_titular")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente titular;

    private Double saldo = 0.0;

    public Boolean depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean sacar(Double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean transferir(Double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
