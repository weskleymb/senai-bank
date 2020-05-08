package br.senai.rn.senaibank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity implements PersistableEntity<Long> {

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "data_criacao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    @LastModifiedDate
    @Column(name = "data_modificacao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataModificacao;

    @Column(name = "ativo")
    private Boolean ativo;

    @JsonIgnore
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @JsonIgnore
    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @JsonIgnore
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataModificacao = LocalDate.now();
    }

}
