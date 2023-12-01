package com.crisromel.proyecto2.controller;


import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosController {

    @Autowired
    private IProductoService service;

    @GetMapping("/productos")
    public List<Producto> getProductos(){

        return service.getProductos();
    }
    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto producto){
        service.saveProducto(producto);
        return "El producto fue creado correctamente";
    }
    @DeleteMapping("/productos/eliminar/{id}")
    public String deleteProducto(@PathVariable Long id){
        service.deleteProducto(id);
        return "El Producto fue eliminado correctamente";
    }

    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto producto){
        service.editProducto(producto);
        return service.findProducto(producto.getCodigo_producto());

    }
}
