package com.crisromel.proyecto2.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantidad_disponible;

}
