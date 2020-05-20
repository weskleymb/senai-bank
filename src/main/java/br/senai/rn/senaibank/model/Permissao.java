package br.senai.rn.senaibank.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "permissoes")
public class Permissao extends AuditableEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String permissao;

    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.permissao;
    }

}
