package com.demo.CRUD_AUTO.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private String color;

    /*Creamos constructores: vacio y
    * con parametros*/
    public Auto() {
    }

    public Auto(Long id, String marca, String modelo, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
}
