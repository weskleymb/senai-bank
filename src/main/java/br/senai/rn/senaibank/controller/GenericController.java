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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class GenericController<T extends AuditableEntity> extends HomeController {

    protected static final String EDIT = "/{id}/edit";
    protected static final String FORM = "/form";
    protected static final String LIST = "/list";
    protected static final String REMOVE = "/{id}/remove";

    @Autowired
    private GenericService<T> service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute(getEntityListName(), service.findAll());
        return page(LIST);
    }

    @PostMapping
    public String save(T entity, RedirectAttributes attributes) {
        service.save(entity);
        attributes.addFlashAttribute("success", getMessage("adicionado"));
        return redirect(LIST);
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
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes) {
        T entity = service.findById(id);
        if (entity != null) {
            model.addAttribute(getEntityName(), entity);
            return page(FORM);
        }
        attributes.addFlashAttribute("error", getMessage("não encontrado"));
        return redirect(NOT_FOUND);
    }

    @GetMapping(value = REMOVE)
    public String remove(@PathVariable(value = "id") Long id, RedirectAttributes attributes) {
        T entity = service.findById(id);
        if (entity != null) {
            attributes.addFlashAttribute("success", getMessage("removido"));
            service.delete(entity.getId());
            return redirect(LIST);
        }
        attributes.addFlashAttribute("error", getMessage("não removido"));
        return redirect(NOT_FOUND);
    }

    protected String page(String page) {
        return getControllerName()
                .concat(StringUtils.isEmpty(page) ? StringUtils.EMPTY : page);
    }

    protected String redirect(String url) {
        return "redirect:"
                .concat(getMapping())
                .concat(StringUtils.isEmpty(url) || url.equals(LIST) ? StringUtils.EMPTY : url);
    }

    protected String getEntityName() {
        return StringUtils.uncapitalize(getGenericType().getSimpleName());
    }

    protected String getEntityListName() {
        StringBuilder builder = new StringBuilder(getEntityName());
        String listSuffix = "List";
        return builder.append(listSuffix).toString();
    }

    protected Class<T> getGenericType() {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    protected String getMapping() {
        return getClass().getAnnotation(RequestMapping.class).value()[0];
    }

    private String getControllerName() {
        String controllerName = getClass().getSimpleName();
        String controllerSuffix = "Controller";
        return StringUtils.uncapitalize(controllerName.replace(controllerSuffix, StringUtils.EMPTY));
    }

    private String getMessage(String message) {
        return StringUtils.capitalize(getEntityName().concat(StringUtils.SPACE).concat(message));
    }

}
