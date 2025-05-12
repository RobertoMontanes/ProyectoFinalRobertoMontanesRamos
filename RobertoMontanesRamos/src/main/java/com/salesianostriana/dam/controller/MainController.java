package com.salesianostriana.dam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.Entrada;
import com.salesianostriana.dam.repository.ClienteRepository;
import com.salesianostriana.dam.repository.EntradaRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ClienteRepository clienteRepo;
    private final EntradaRepository entradaRepo;

    @GetMapping("/")
    public String index(Model model) {
        List<Cliente> clientes = clienteRepo.findAll();

        // Cargar las entradas asociadas a cada cliente
        for (Cliente cliente : clientes) {
            List<Entrada> entradas = entradaRepo.findByCliente(cliente);
            cliente.setEntradas(entradas);
        }

        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                 @RequestParam String password,
                                 Model model) {
        Optional<Cliente> clienteOpt = clienteRepo.findByEmailAndPassword(email, password);
        if (clienteOpt.isPresent()) {
            model.addAttribute("cliente", clienteOpt.get());
            return "cliente-panel";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }
}

