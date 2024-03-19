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
@RequestMapping(path = "api/v1/producto")
public class ProductoController {
    private final ProductoService productService;

    // Inyección de dependencias
    @Autowired
    public ProductoController(ProductoService destinoService) {
        this.productService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> list = productService.getEjemplos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Producto> addOrUpdate(@RequestBody Producto producto) {
        Producto addOrUpdateEjemplo = productService.addOrUpdateEjemplo(producto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(addOrUpdateEjemplo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProductById(@PathVariable Long id, @RequestBody Producto updatedProduct) {
        // Verificar si el producto con el ID proporcionado existe en la base de datos
        Optional<Producto> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Producto>> getByName(@PathVariable String name) {
        List<Producto> list = productService.getProductoByNames(name);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        // Verificar si el producto con el ID proporcionado existe en la base de datos
        Optional<Producto> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Si el producto existe, eliminarlo de la base de datos
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stock-zero")
    public ResponseEntity<List<Producto>> filterProductsWithZeroStock() {
        List<Producto> productosWithZeroStock = productService.filterProductsWithZeroStock();
        return ResponseEntity.ok(productosWithZeroStock);
    }


}