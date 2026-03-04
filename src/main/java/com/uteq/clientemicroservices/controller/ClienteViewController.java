package com.uteq.clientemicroservices.controller;

import com.uteq.clientemicroservices.entity.Cliente;
import com.uteq.clientemicroservices.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes") // antes era /vistas/clientes
public class ClienteViewController {

    private final ClienteService clienteService;

    public ClienteViewController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Listar clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "clientes"; // clientes.html
    }

    // Formulario nuevo cliente
    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente_form"; // cliente_form.html
    }

    // Guardar cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    // Editar cliente
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        model.addAttribute("cliente", cliente);
        return "cliente_form";
    }

    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
