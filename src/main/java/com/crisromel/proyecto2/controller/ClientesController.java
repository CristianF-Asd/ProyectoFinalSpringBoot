package com.crisromel.proyecto2.controller;


import com.crisromel.proyecto2.entity.Cliente;
import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.service.IClienteService;
import com.crisromel.proyecto2.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientesController {


    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){

        return service.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Long id){
        Cliente cliente = service.findCliente(id);
        return cliente;
    }

    @PostMapping("/clientes/crear")
    public String createCliente(@RequestBody Cliente cliente){
        service.saveCliente(cliente);
        return "El Cliente fue creado correctamente";
    }
    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return "El Cliente fue eliminado correctamente";
    }

    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente cliente){
        service.editCliente(cliente);
        return service.findCliente(cliente.getId_cliente());
    }
}
