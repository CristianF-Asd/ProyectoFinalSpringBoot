package com.crisromel.proyecto2.controller;


import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.entity.Venta;
import com.crisromel.proyecto2.entity.VentaDTO;
import com.crisromel.proyecto2.service.IProductoService;
import com.crisromel.proyecto2.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService service;

    @Autowired
    private IProductoService proservice;

    @GetMapping("/ventas")
    public List<Venta> getVentas(){

        return service.getVentas();
    }

    @GetMapping("/ventas/productos/{id}")
    public List<Producto> getProductosVenta(@PathVariable Long id){
        return service.getProductosdeVenta(id);
    }

    @GetMapping("/ventas/fecha/{date}")
    public double getTotalVentas(@PathVariable LocalDate date){
        return service.getTotalVentas(date);
    }



    @GetMapping("/ventas/{id}")
    public Venta getVentas(@PathVariable Long id){
        Venta venta = service.findVenta(id);
        return venta;
    }

    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta){
        boolean a = service.saveVenta(venta);
        if(a==true){
            return "La Venta fue creada correctamente";
        }else{
            return "La Venta no fue concretada, no hay suficiente stock";
        }

    }
    @DeleteMapping("/ventas/eliminar/{id}")
    public String deleteVenta(@PathVariable Long id){
        service.deleteVenta(id);
        return "La venta fue eliminada correctamente";
    }

    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta venta){
        service.editVenta(venta);
        return service.findVenta(venta.getCodigo_venta());

    }

    @GetMapping("/ventas/mayor_venta")
    public VentaDTO mayorVenta(){
        return service.MayorVenta();
    }



}
