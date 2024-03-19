package com.utadexamen.examen.service;

import com.utadexamen.examen.model.Producto;
import com.utadexamen.examen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository ejemploRepository) {
        this.productoRepository = ejemploRepository;
    }

    public List<Producto> getEjemplos(){
        return productoRepository.findAll();
    }


    public Producto addOrUpdateEjemplo(Producto ejemplo){
        return productoRepository.save(ejemplo);
    }



    public List<Producto> getProductoByNames(String name) {
        return productoRepository.findByNameContainingIgnoreCase(name);
    }


    public Optional<Producto> getProductById(Long id) {
        return productoRepository.findById(id);
    }

    public void deleteProductById(Long id) {
    }


    public List<Producto> filterProductsWithZeroStock() {
        // Implementa la lógica para filtrar productos con stock igual a cero
        return productoRepository.findByStockEquals(0);
    }
}