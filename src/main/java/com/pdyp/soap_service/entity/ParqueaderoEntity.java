package com.pdyp.soap_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parqueadero")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParqueaderoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parqueadero_seq")
    @SequenceGenerator(name = "parqueadero_seq", sequenceName = "parqueadero_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "administrador")
    private String administrador;

    @Column(name = "ciudad")
    private String ciudad;
}
