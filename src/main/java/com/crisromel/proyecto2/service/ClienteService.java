package com.crisromel.proyecto2.service;


import com.crisromel.proyecto2.entity.Cliente;
import com.crisromel.proyecto2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements  IClienteService{

    @Autowired
    private ClienteRepository repository;
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        repository.save(cliente);

    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);

    }
}
