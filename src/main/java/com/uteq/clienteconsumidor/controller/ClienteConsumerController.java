package com.uteq.clienteconsumidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/clientes-view")
    public Object obtenerClientes() {

        // String url = "http://68.155.227.209/api/clientes";
        String url = "http://cliente-micropservice:8080/api/clientes";
        // LOCAL para probar primero

        return restTemplate.getForObject(url, Object.class);
    }
}