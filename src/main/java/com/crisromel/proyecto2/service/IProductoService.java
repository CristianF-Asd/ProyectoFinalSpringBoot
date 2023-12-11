package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();



    public List<Producto> getFaltaStock();

    public void saveProducto (Producto producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

    public void editProducto(Producto producto);

    public boolean checkSctock(Producto producto);

}
