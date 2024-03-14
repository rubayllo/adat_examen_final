package com.utadexamen.examen.controller;

import com.utadexamen.examen.model.Ejemplo;
import com.utadexamen.examen.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// UrlBase = http://localhost:8080
// ruta Url = /api/v1/ejemplo
@RestController
@RequestMapping(path = "api/v1/ejemplo")
public class EjemploController {
    private final EjemploService ejemploService;

    // Inyección de dependencias
    @Autowired
    public EjemploController(EjemploService destinoService){
        this.ejemploService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Ejemplo>> getAll() {
        List<Ejemplo> list = ejemploService.getEjemplos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Ejemplo> addOrUpdate(@RequestBody Ejemplo ejemplo) {
        Ejemplo addOrUpdateEjemplo = ejemploService.addOrUpdateEjemplo(ejemplo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(addOrUpdateEjemplo);
    }

    @GetMapping("/{idDestino}")
    public ResponseEntity<Optional<Ejemplo>> getById(@PathVariable Long idDestino) {
        Optional<Ejemplo> ejemplo = Optional.ofNullable(ejemploService.getEjemploById(idDestino));

        if(ejemplo.isPresent()){
            return ResponseEntity.ok(ejemplo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Ejemplo>> getByCity(@PathVariable String city) {
        List<Ejemplo> list = ejemploService.getEjemplosByCity(city);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Ejemplo>> getByCountry(@PathVariable String country) {
        List<Ejemplo> list = ejemploService.getEjemplosByCountry(country);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{idDestino}")
    public ResponseEntity<Optional<Ejemplo>> delete(@PathVariable Long idDestino) {
        ejemploService.deleteEjemplo(idDestino);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/contains/{str}")
    public ResponseEntity<List<Ejemplo>> getByCityContains(@PathVariable String str) {
        List<Ejemplo> list = ejemploService.getEjemplosByCityContains(str);
        return ResponseEntity.ok(list);
    }

}