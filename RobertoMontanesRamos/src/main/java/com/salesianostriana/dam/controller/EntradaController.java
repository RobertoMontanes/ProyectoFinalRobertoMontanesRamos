package com.salesianostriana.dam.controller;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.Entrada;
import com.salesianostriana.dam.service.EntradaService;
import com.salesianostriana.dam.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class EntradaController {

    private final EntradaService entradaService;
    private final ClienteService clienteService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entradasDisponibles", entradaService.findDisponibles());
        model.addAttribute("clientes", clienteService.findAll());
        return "index";
    }

    @PostMapping("/asignar")
    public String asignarEntrada(@RequestParam("entradaId") Long entradaId,
                                @RequestParam("clienteId") Long clienteId) {
        Entrada entrada = entradaService.findById(entradaId).orElse(null);
        Cliente cliente = clienteService.findById(clienteId).orElse(null);

        if (entrada != null && cliente != null) {
            entrada.setCliente(cliente);
            entrada.setVendida(true);
            entradaService.save(entrada);
        }

        return "redirect:/";
    }

    @GetMapping("/nueva")
    public String showNuevaEntrada(Model model) {
        model.addAttribute("entrada", Entrada.builder().fechaHora(LocalDateTime.now()).build());
        return "admin/form-entrada";
    }

    @PostMapping("/nueva/submit")
    public String submitNuevaEntrada(@ModelAttribute("entrada") Entrada entrada) {
        entradaService.save(entrada);
        return "redirect:/admin/entradas/";
    }

    @GetMapping("/admin/entradas/")
    public String listEntradas(Model model) {
        model.addAttribute("entradas", entradaService.findAll());
        return "admin/list-entradas";
    }

    @GetMapping("/admin/entradas/borrar/{id}")
    public String deleteEntrada(@PathVariable Long id) {
        entradaService.deleteById(id);
        return "redirect:/admin/entradas/";
    }
}