package com.uteq.clienteconsumidor.service;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClienteApiService {

    private final RestClient restClient;

    public ClienteApiService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://cliente-microservicio")
                .build();
    }

    public String obtenerClientes() {
        return restClient.get()
                .uri("/api/clientes")
                .retrieve()
                .body(String.class);
    }
}