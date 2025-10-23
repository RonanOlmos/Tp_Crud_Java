package main.models;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Triviacard extends Card {
    private String pregunta;
    private List<String> opciones;
    private int indiceCorrecto;

    public Triviacard(Categoria categoria, 
                      String pregunta, List<String> opciones, int indiceCorrecto) {
        super(categoria);
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
    void mostrarPreguntas(){
        for (String string : opciones) 
            System.out.println("\t"+string+"\n");
    }
    @Override
    public String toString() {
        return "Triviacard{\nid : " + getId() +
                ", \nCategoria : "+ getCategoria().getNombre() + 
                ", \nPregunta : " + pregunta +
                ", \nOpciones : " + opciones.toString() +
                ", \nIndice Correcto : " + indiceCorrecto +
                ", \nFecha de creacion : " + getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                "\n}";
    } 

    
}
