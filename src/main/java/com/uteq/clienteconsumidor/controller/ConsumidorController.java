package com.uteq.clienteconsumidor.controller;


import com.uteq.clienteconsumidor.model.Cliente;
import com.uteq.clienteconsumidor.service.ClienteApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumiendo-cliente")
public class ConsumidorController {

    private final ClienteApiService clienteApiService;

    public ConsumidorController(ClienteApiService clienteApiService) {
        this.clienteApiService = clienteApiService;
    }

    // 1️⃣ Clientes mayores de 18
    @GetMapping("/mayores-18")
    public List<Cliente> mayoresDe18() throws Exception {
        return clienteApiService.obtenerClientes()
                .stream()
                .filter(c -> c.getEdad() > 18)
                .toList();
    }

    // 2️⃣ Clientes por ciudad
    @GetMapping("/ciudad/{ciudad}")
    public List<Cliente> porCiudad(@PathVariable String ciudad) throws Exception {
        return clienteApiService.obtenerClientes()
                .stream()
                .filter(c -> c.getCiudad().equalsIgnoreCase(ciudad))
                .toList();
    }

    // 3️⃣ Total de clientes
    @GetMapping("/total")
    public int totalClientes() throws Exception {
        return clienteApiService.obtenerClientes().size();
    }

    // 4️⃣ Edad promedio
    @GetMapping("/edad-promedio")
    public double edadPromedio() throws Exception {
        return clienteApiService.obtenerClientes()
                .stream()
                .mapToInt(Cliente::getEdad)
                .average()
                .orElse(0);
    }

    // 5️⃣ Clientes mayores de 30 (ejecutivos)
    @GetMapping("/mayores-30")
    public List<Cliente> mayoresDe30() throws Exception {
        return clienteApiService.obtenerClientes()
                .stream()
                .filter(c -> c.getEdad() > 30)
                .toList();
    }

    @GetMapping("/vista")
    public String dashboard() {
        return "mostrando-pantalla";
    }
}