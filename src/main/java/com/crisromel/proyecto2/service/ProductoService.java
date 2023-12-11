package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.entity.Venta;
import com.crisromel.proyecto2.repository.ProductoRepository;
import com.crisromel.proyecto2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = repository.findAll();
        return listaProductos;
    }



    @Override
    public List<Producto> getFaltaStock() {
        List<Producto> Productos = repository.findAll();
        List<Producto> SinStock = new ArrayList<Producto>();
        for(int i=0; i<Productos.size();i++){
            if(Productos.get(i).getCantidad_disponible()<5){
                SinStock.add(Productos.get(i));
            }
        }
        return SinStock;
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

    @Override
    public boolean checkSctock(Producto producto) {
        if(producto.getCantidad_disponible()==0){
            return false;
        }else{
            return true;
        }

    }
}
