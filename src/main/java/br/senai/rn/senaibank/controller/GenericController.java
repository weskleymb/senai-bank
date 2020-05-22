package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.AuditableEntity;
import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.service.GenericService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericController<T extends AuditableEntity> {

    protected static final String LISTA = "/lista";
    protected static final String FORMULARIO = "/formulario";

    @Autowired
    protected GenericService<T> service;

    @GetMapping
    public String lista(Model model) {
        String lista = getNomeEntidadeLista();
        List<T> entidades = service.buscaTodos();
        model.addAttribute(lista, entidades);
        return pagina(LISTA);
    }

    @GetMapping(value = FORMULARIO)
    public String formulario(Model model) {
        try {
            String nomeEntidade = getNomeEntidade();
            T entidade = getTipoGenerico().getDeclaredConstructor().newInstance();
            model.addAttribute(nomeEntidade, entidade);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return pagina(FORMULARIO);
    }

    protected String getNomeEntidadeLista() {
        String nomeEntidadeLista = getNomeEntidade();
        String sufixoLista = "Lista";
        return nomeEntidadeLista + sufixoLista;
    }

    protected String getNomeEntidade() {
        return StringUtils.uncapitalize(getTipoGenerico().getSimpleName());
    }

    protected Class<T> getTipoGenerico() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected String pagina(String pagina) {
        return getNomeControlador().concat(pagina);
    }

    protected String getNomeControlador() {
        String nomeDoControlador = getClass().getSimpleName();
        String sufixoDoControlador = "Controller";
        return StringUtils.uncapitalize(nomeDoControlador.replace(sufixoDoControlador, StringUtils.EMPTY));
    }


}
