package com.salesianostriana.dam.controller;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/")
    public String listClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "admin/list-clientes";
    }

    @GetMapping("/nuevo")
    public String showForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/form-cliente";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/admin/cliente/";
    }

    @GetMapping("/editar/{id}")
    public String editCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id).orElse(null);
        if (cliente == null) {
            return "redirect:/admin/cliente/";
        }
        model.addAttribute("cliente", cliente);
        return "admin/form-cliente";
    }

    @GetMapping("/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/admin/cliente/";
    }
}