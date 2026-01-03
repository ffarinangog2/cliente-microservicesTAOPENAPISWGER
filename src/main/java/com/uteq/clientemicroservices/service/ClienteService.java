package com.uteq.clientemicroservices.service;

import com.uteq.clientemicroservices.entity.Cliente;
import com.uteq.clientemicroservices.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(clienteActualizado.getNombre());
                    cliente.setEmail(clienteActualizado.getEmail());
                    cliente.setTelefono(clienteActualizado.getTelefono());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

