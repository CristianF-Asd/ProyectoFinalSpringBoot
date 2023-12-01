package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repository;
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = repository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) {
        repository.save(producto);

    }

    @Override
    public void deleteProducto(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto = repository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);

    }
}
