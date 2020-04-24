package br.senai.rn.senaibank.model;

import java.util.Objects;

public class Conta {

    private Long id;

    private Cliente titular;

    private String numero;

    private Double saldo;

    public Conta() {}

    public Conta(Cliente titular, String numero, Double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id) &&
                Objects.equals(titular, conta.titular) &&
                Objects.equals(numero, conta.numero) &&
                Objects.equals(saldo, conta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titular, numero, saldo);
    }

}
