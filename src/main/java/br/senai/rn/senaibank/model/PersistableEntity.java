package br.senai.rn.senaibank.model;

import java.io.Serializable;

public interface PersistableEntity<PK extends Serializable> {

    PK getId();

    void setId(PK id);

}
