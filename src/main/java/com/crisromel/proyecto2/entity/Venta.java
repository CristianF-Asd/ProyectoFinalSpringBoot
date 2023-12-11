package com.crisromel.proyecto2.entity;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;

    @OneToMany
    private List <Producto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "fk_cliente",
    referencedColumnName = "id_cliente")
    private Cliente unCliente;
}
