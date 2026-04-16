package com.SIS414.Emergentes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/peliculas")
@Tag(name = "Películas", description = "API para gestión de películas")
public class PeliculasAvatar {

    private List<Pelicula> peliculas = new ArrayList<>();
    private Long nextId = 1L;

    // GET - Obtener todas las películas
    @GetMapping
    @Operation(summary = "Obtener todas las películas")
    public ResponseEntity<List<Pelicula>> getAll() {
        return ResponseEntity.ok(peliculas);
    }

    // GET - Obtener película por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una película por ID")
    public ResponseEntity<Pelicula> getById(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return pelicula.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Crear nueva película
    @PostMapping
    @Operation(summary = "Crear una nueva película")
    public ResponseEntity<Pelicula> create(@RequestBody Pelicula pelicula) {
        pelicula.setId(nextId++);
        peliculas.add(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    // PUT - Actualizar película
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una película existente")
    public ResponseEntity<Pelicula> update(@PathVariable Long id, @RequestBody Pelicula nueva) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId().equals(id)) {
                nueva.setId(id);
                peliculas.set(i, nueva);
                return ResponseEntity.ok(nueva);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE - Eliminar película
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una película")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = peliculas.removeIf(p -> p.getId().equals(id));
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}