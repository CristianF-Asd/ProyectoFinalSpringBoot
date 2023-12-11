package com.crisromel.proyecto2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
}
