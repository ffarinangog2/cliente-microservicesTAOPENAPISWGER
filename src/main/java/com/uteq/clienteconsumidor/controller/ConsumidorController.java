package com.uteq.clienteconsumidor.controller;


import com.uteq.clienteconsumidor.service.ClienteApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumidorController {

    private final ClienteApiService clienteApiService;

    public ConsumidorController(ClienteApiService clienteApiService) {
        this.clienteApiService = clienteApiService;
    }

    @GetMapping("/microconsumidor/clientes")
    public String consumirClientes() {
        return clienteApiService.obtenerClientes();
    }
}