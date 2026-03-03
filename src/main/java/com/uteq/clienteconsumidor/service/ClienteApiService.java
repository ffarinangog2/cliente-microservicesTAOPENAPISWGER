package com.uteq.clienteconsumidor.service;



import com.uteq.clienteconsumidor.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class ClienteApiService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ClienteApiService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://cliente-microservicio")
                .build();
    }

    public List<Cliente> obtenerClientes() throws Exception {
        String json = restClient.get()
                .uri("/api/clientes")
                .retrieve()
                .body(String.class);

        return objectMapper.readValue(json, new TypeReference<List<Cliente>>() {});
    }
}