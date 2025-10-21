package main.models;

public class Categoria {
    private int id;
    private String nombre;

    private static int contador = 1;

    public Categoria(String nombre){
        this.nombre = nombre;
        this.id = contador++;
    }

    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombreNuevo){
        this.nombre = nombreNuevo;
    }

    @Override
    public String toString() {
        return "Categoria[Id : " + id + ", Nombre : "+ nombre +"]\n";
    }
}
