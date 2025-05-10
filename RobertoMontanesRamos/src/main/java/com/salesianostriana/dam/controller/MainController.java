package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.Entrada;
import com.salesianostriana.dam.service.ClienteService;

@Controller
public class MainController {

    private final ClienteService clienteService;

    public MainController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        Cliente cliente = new Cliente();
        cliente.setEntradas(List.of(new Entrada())); // Asegúrate de tener el setter
        model.addAttribute("cliente", cliente);
        return "index";
    }

    @PostMapping("/clientes/crear")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/";
    }
}
