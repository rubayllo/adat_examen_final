package com.utadexamen.examen.repository;

import com.utadexamen.examen.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNameContainingIgnoreCase(String name);

    List<Producto> findByStockEquals(Integer stock);

}