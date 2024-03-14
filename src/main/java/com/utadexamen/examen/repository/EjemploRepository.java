package com.utadexamen.examen.repository;

import com.utadexamen.examen.model.Ejemplo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjemploRepository extends JpaRepository<Ejemplo, Long> {

    List<Ejemplo> findByCityContainingIgnoreCase(String city);

    List<Ejemplo> findByCountryContainingIgnoreCase(String country);


    List<Ejemplo> findByCityContains(String city);

}