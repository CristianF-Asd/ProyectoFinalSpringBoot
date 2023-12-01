package com.crisromel.proyecto2.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    private List <Producto> listaProductos;
    private Cliente unCliente;
}
