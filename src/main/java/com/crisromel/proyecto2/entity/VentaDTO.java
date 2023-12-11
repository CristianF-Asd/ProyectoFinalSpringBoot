package com.crisromel.proyecto2.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO implements Serializable {
    private Long codigo_denta;
    private Double total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
    private double monto_alto;
}
