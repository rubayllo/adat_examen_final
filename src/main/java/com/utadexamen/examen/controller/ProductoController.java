package com.utadexamen.examen.controller;

import com.utadexamen.examen.model.Producto;
import com.utadexamen.examen.service.ProductoService;
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
public class ProductoController {
    private final ProductoService ejemploService;

    // Inyección de dependencias
    @Autowired
    public ProductoController(ProductoService destinoService){
        this.ejemploService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> list = ejemploService.getEjemplos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Producto> addOrUpdate(@RequestBody Producto ejemplo) {
        Producto addOrUpdateEjemplo = ejemploService.addOrUpdateEjemplo(ejemplo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(addOrUpdateEjemplo);
    }

    @GetMapping("/{idDestino}")
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long idDestino) {
        Optional<Producto> ejemplo = Optional.ofNullable(ejemploService.getEjemploById(idDestino));

        if(ejemplo.isPresent()){
            return ResponseEntity.ok(ejemplo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Producto>> getByCity(@PathVariable String city) {
        List<Producto> list = ejemploService.getEjemplosByCity(city);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Producto>> getByCountry(@PathVariable String country) {
        List<Producto> list = ejemploService.getEjemplosByCountry(country);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{idDestino}")
    public ResponseEntity<Optional<Producto>> delete(@PathVariable Long idDestino) {
        ejemploService.deleteEjemplo(idDestino);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/contains/{str}")
    public ResponseEntity<List<Producto>> getByCityContains(@PathVariable String str) {
        List<Producto> list = ejemploService.getEjemplosByCityContains(str);
        return ResponseEntity.ok(list);
    }

}