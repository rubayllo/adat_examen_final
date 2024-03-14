package com.utadexamen.examen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ejemplo_examen")
public class Ejemplo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private Long population;
}