package br.senai.rn.senaibank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contas_correntes")
public class ContaCorrente extends Conta {

}
