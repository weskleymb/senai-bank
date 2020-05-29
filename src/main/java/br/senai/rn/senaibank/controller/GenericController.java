package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.AuditableEntity;
import br.senai.rn.senaibank.service.GenericService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericController<T extends AuditableEntity> {

    protected static final String LISTA = "/lista";
    protected static final String FORMULARIO = "/formulario";
    protected static final String REMOVER = "/{id}/remover";

    @Autowired
    protected GenericService<T> service;

    @GetMapping
    public String lista(Model model) {
        String lista = getNomeEntidadeLista();
        List<T> entidades = service.buscaTodos();
        model.addAttribute(lista, entidades);
        System.out.println(lista);
        return pagina(LISTA);
    }

    @GetMapping(value = FORMULARIO)
    public String formulario(Model model) {
        try {
            String nomeEntidade = getNomeEntidade();
            T entidade = getTipoGenerico().getDeclaredConstructor().newInstance();
            model.addAttribute(nomeEntidade, entidade);
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return pagina(FORMULARIO);
    }

    @PostMapping
    public String salva(T entidade) {
        service.salva(entidade);
        return redireciona(LISTA);
    }

    @PostMapping(value = REMOVER)
    public String remover(@PathVariable(value = "id") Long id) {
        T entidade = service.buscaPorId(id);
        if (ObjectUtils.isNotEmpty(entidade)) {
            service.remover(entidade);
        }
        return redireciona(LISTA);
    }

//    @GetMapping(value = "/{id}/remover")
//    public String remover(@PathVariable(value = "id") Long id) {
//        Cliente cliente = service.buscaPorId(id);
//        if (cliente != null) {
//            service.remover(cliente);
//        }
//        return "redirect:/clientes/lista";
//    }

    protected String pagina(String pagina) {
        return getNomeControlador().concat(pagina);
    }

    protected String redireciona(String url) {
        return "redirect:"
                + getMapeamento()
                + (StringUtils.isEmpty(url) || url.equals(LISTA) ? StringUtils.EMPTY : url);
    }

    protected String getMapeamento() {
        return getClass().getAnnotation(RequestMapping.class).value()[0];
    }

    protected String getNomeEntidadeLista() {
        String nomeEntidadeLista = getNomeEntidade();
        String sufixoLista = "Lista";
//        return nomeEntidadeLista + sufixoLista;
        return getMapeamento().replace("/", "");
    }

    protected String getNomeEntidade() {
        return StringUtils.uncapitalize(getTipoGenerico().getSimpleName());
    }

    protected Class<T> getTipoGenerico() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected String getNomeControlador() {
        String nomeDoControlador = getClass().getSimpleName();
        String sufixoDoControlador = "Controller";
        return StringUtils.uncapitalize(nomeDoControlador.replace(sufixoDoControlador, StringUtils.EMPTY));
    }

}
