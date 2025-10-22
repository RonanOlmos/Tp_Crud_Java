package main.models;

import java.time.LocalDateTime;

public abstract class Card {
    private int id;
    private Categoria categoria;
    private LocalDateTime fechaCreacion;

    private static int contador = 1;

    public Card (int id, Categoria categoria){
        this.id = contador++;
        this.categoria = categoria;
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getId(){
        return this.id;
    }
    public Categoria getCategoria(){
        return this.categoria;
    }
    public void setCategoria(Categoria nuevaCategoria){
        this.categoria = nuevaCategoria;
    }
    public LocalDateTime getFechaCreacion(){
        return this.fechaCreacion;
    }
}
