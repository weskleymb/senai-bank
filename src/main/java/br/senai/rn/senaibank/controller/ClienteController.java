package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import br.senai.rn.senaibank.model.Usuario;
import br.senai.rn.senaibank.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController extends GenericController<Cliente> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public String formulario(Model modelo) {
        List<Sexo> sexos = Arrays.asList(Sexo.values());
        modelo.addAttribute("sexos", sexos);
        return super.formulario(modelo);
    }

    @Override
    @GetMapping(value = EDITAR)
    public String editar(@PathVariable(value = "id") Long id, Model modelo) {
        List<Sexo> sexos = Arrays.asList(Sexo.values());
        modelo.addAttribute("sexos", sexos);
        return super.editar(id, modelo);
    }

    @Override
    public String salva(Cliente cliente, RedirectAttributes atributos) {
        Usuario usuario = new Usuario();
        usuario.setNome(cliente.getNome());
        usuario.setLogin(cliente.getCpf());
        usuario.setSenha(cliente.getUsuario().getSenha());
        usuarioService.salva(usuario);
        cliente.setUsuario(usuario);
        return super.salva(cliente, atributos);
    }
}
