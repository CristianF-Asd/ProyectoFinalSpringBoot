package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Cliente;

import java.util.List;


public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente (Cliente cliente);

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void editCliente(Cliente cliente);
}
