package com.SIS414.Emergentes;

public class Pelicula {
    private Long id;
    private String titulo;
    private String genero;
    private int año;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getAnio() { return año; }
    public void setAnio(int anio) { this.año = anio; }
}