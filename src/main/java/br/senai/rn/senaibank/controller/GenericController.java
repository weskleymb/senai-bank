package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.AuditableEntity;
import br.senai.rn.senaibank.service.GenericService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class GenericController<T extends AuditableEntity> {

    protected static final String EDIT = "/{id}/edit";
    protected static final String FORM = "/form";
    protected static final String LIST = "/list";
    protected static final String REMOVE = "/{id}/remove";
    protected static final String NOT_FOUND = "/not-found";
    protected static final String SUFIXO_CONTROLLER = "Controller";
    protected static final String SUFIXO_LISTA = "List";

    @Autowired
    private GenericService<T> service;

    protected String page(String path) {
        return getControllerName()
                .concat(StringUtils.isNotEmpty(path) ? path : "");
    }

    protected String redirect(String path) {
        return "redirect:"
                .concat(getMapping())
                .concat(StringUtils.isNotEmpty(path) ? path : "");
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute(getEntityListName(), service.findAll());
        System.out.println(page(LIST));
        return page(LIST);
    }

    @GetMapping(value = NOT_FOUND)
    public String notFound() {
        return "not-found";
    }

    @PostMapping
    public String save(T entity) {
        service.save(entity);
        return redirect(null);
    }

    @GetMapping(value = FORM)
    public String form(Model model) {
        try {
            model.addAttribute(getEntityName(), getGenericType().getDeclaredConstructor().newInstance());
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return page(FORM);
    }

    @GetMapping(value = EDIT)
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        T entity = service.findById(id);
        if (entity == null) {
            return redirect(NOT_FOUND);
        }
        model.addAttribute(getEntityName(), entity);
        return page(FORM);
    }

    @GetMapping(value = REMOVE)
    public String remove(@PathVariable(value = "id") Long id) {
        T entity = service.findById(id);
        if (entity == null) {
            return redirect("not-found");
        }
        service.delete(entity.getId());
        return redirect(null);
    }

    protected String getEntityName() {
        return StringUtils.uncapitalize(getGenericType().getSimpleName());
    }

    protected String getEntityListName() {
        StringBuilder builder = new StringBuilder(getEntityName());
        return builder.append(SUFIXO_LISTA).toString();
    }

    protected Class<T> getGenericType() {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    private String getControllerName() {
        String controllerName = getClass().getSimpleName();
        return StringUtils.uncapitalize(controllerName.replace(SUFIXO_CONTROLLER, ""));
    }

    protected String getMapping() {
        return getClass().getAnnotation(RequestMapping.class).value()[0];
    }

}
