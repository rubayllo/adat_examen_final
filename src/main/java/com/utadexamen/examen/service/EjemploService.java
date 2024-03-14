package com.utadexamen.examen.service;

import com.utadexamen.examen.model.Ejemplo;
import com.utadexamen.examen.repository.EjemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemploService {

    private final EjemploRepository ejemploRepository;

    @Autowired
    public EjemploService(EjemploRepository ejemploRepository) {
        this.ejemploRepository = ejemploRepository;
    }

    public List<Ejemplo> getEjemplos(){
        return ejemploRepository.findAll();
    }

    public Ejemplo getEjemploById(Long id){
        return ejemploRepository.findById(id).orElse(null);
    }

    public Ejemplo addOrUpdateEjemplo(Ejemplo ejemplo){
        return ejemploRepository.save(ejemplo);
    }

    public void deleteEjemplo(Long id){
        ejemploRepository.deleteById(id);
    }



    // Zona de Servicios creados en Repositorio
    public List<Ejemplo> getEjemplosByCityContains(String str) {
            return ejemploRepository.findByCityContains(str);
    }

    public List<Ejemplo> getEjemplosByCity(String city){
        return ejemploRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Ejemplo> getEjemplosByCountry(String country) {
        return ejemploRepository.findByCountryContainingIgnoreCase(country);
    }
}