package com.utadexamen.examen.service;

import com.utadexamen.examen.model.Producto;
import com.utadexamen.examen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository ejemploRepository;

    @Autowired
    public ProductoService(ProductoRepository ejemploRepository) {
        this.ejemploRepository = ejemploRepository;
    }

    public List<Producto> getEjemplos(){
        return ejemploRepository.findAll();
    }

    public Producto getEjemploById(Long id){
        return ejemploRepository.findById(id).orElse(null);
    }

    public Producto addOrUpdateEjemplo(Producto ejemplo){
        return ejemploRepository.save(ejemplo);
    }

    public void deleteEjemplo(Long id){
        ejemploRepository.deleteById(id);
    }



    // Zona de Servicios creados en Repositorio
    public List<Producto> getEjemplosByCityContains(String str) {
            return ejemploRepository.findByCityContains(str);
    }

    public List<Producto> getEjemplosByCity(String city){
        return ejemploRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Producto> getEjemplosByCountry(String country) {
        return ejemploRepository.findByCountryContainingIgnoreCase(country);
    }
}