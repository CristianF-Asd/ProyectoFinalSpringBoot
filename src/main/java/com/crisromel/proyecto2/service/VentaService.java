package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Cliente;
import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.entity.Venta;
import com.crisromel.proyecto2.entity.VentaDTO;
import com.crisromel.proyecto2.repository.ProductoRepository;
import com.crisromel.proyecto2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class VentaService implements  IVentaService{

    @Autowired
    private ProductoRepository proRepository;

    @Autowired
    private VentaRepository repository;
    @Override
    public List<Venta> getVentas() {
        List<Venta> ventas = repository.findAll();
        return ventas;
    }

    @Override
    public boolean saveVenta(Venta venta) {
        List<Producto> productos = venta.getListaProductos();

        for(int i=0; i<productos.size(); i++){

            Producto producto = proRepository.findById(productos.get(i).getCodigo_producto()).orElse(null);
            if(producto.getCantidad_disponible()<=0){

                return false;
            }
        }
        venta.setFecha_venta(LocalDate.now());
        repository.save(venta);
        return true;
    }

    @Override
    public void deleteVenta(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Venta findVenta(Long id) {
        Venta venta = repository.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);

    }

    @Override
    public double getTotalVentas(LocalDate date) {
        List<Venta> ventas = repository.findAll();
        double total =0;
        for(int i=0; i<ventas.size();i++){
            if(ventas.get(i).getFecha_venta().equals(date)){
                total=ventas.get(i).getTotal()+total;
            }
        }
        return total;
    }

    @Override
    public VentaDTO MayorVenta() {
        List<Venta> ventas = repository.findAll();
        Long id= 0L;
        for(int i=0; i<ventas.size();i++){
            if(ventas.get(i).getTotal()>=0){
                id=ventas.get(i).getCodigo_venta();
            }
        }
        Venta venta = repository.findById(id).orElse(null);
        Cliente cliente = venta.getUnCliente();

        VentaDTO ventadto = new VentaDTO();
        ventadto.setCodigo_denta(id);
        ventadto.setTotal(venta.getTotal());
        ventadto.setCantidad_productos(venta.getListaProductos().size());
        ventadto.setNombre_cliente(cliente.getNombre());
        ventadto.setApellido_cliente(cliente.getApellido());
        ventadto.setMonto_alto(venta.getTotal());

        return ventadto;
    }

    @Override
    public List<Producto> getProductosdeVenta(Long id) {
        Venta a = repository.findById(id).orElse(null);
        List <Producto> productos = a.getListaProductos();
        return productos;
    }
}
