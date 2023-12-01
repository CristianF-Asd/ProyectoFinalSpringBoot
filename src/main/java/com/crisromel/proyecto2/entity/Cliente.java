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
public class Cliente {

    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
}
