package main.models;

import java.util.List;

public class Triviacard extends Card {
    private String pregunta;
    private List<String> opciones;
    private int indiceCorrecto;

    public Triviacard(int id, Categoria categoria, 
                      String pregunta, List<String> opciones, int indiceCorrecto) {
        super(id, categoria);
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.indiceCorrecto = indiceCorrecto;
    }

    String getPregunta() {
        return pregunta;
    }
    void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    List<String> getOpciones() {
        return opciones;
    }
    void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
    int getIndiceCorrecto() {
        return indiceCorrecto;
    }
    void setIndiceCorrecto(int indiceCorrecto) {
        this.indiceCorrecto = indiceCorrecto;
    }
    @Override
    public String toString() {
        return "Triviacard[Id : " + getId() +", "+
               getCategoria().toString() + ", Pregunta : " + pregunta +
               ", Opciones : " + opciones.toString() +
               ", Indice Correcto : " + indiceCorrecto +
               ", Fecha de creacion : " + getFechaCreacion() +"]";
    }

    
}
