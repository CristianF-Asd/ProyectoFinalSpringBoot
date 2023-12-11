package com.crisromel.proyecto2.service;

import com.crisromel.proyecto2.entity.Producto;
import com.crisromel.proyecto2.entity.Venta;
import com.crisromel.proyecto2.entity.VentaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public List<Producto> getProductosdeVenta(Long id);

    public boolean saveVenta (Venta venta);

    public void deleteVenta(Long id);

    public Venta findVenta(Long id);

    public void editVenta(Venta venta);

    public double getTotalVentas(LocalDate date);

    public VentaDTO MayorVenta();
}
