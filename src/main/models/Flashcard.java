package main.models;

import java.time.format.DateTimeFormatter;

public class Flashcard extends Card{
    private String pregunta;
    private String respuesta;
    private Nivel nivel;

    public Flashcard(Categoria categoria,
                     String pregunta, String respuesta, Nivel nivel) {
        super(categoria);
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.nivel = nivel;
    }

    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Nivel getNivel() {
        return nivel;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    @Override
    public String toString() {
        return "Flashcard{\nid : " + getId() +", \nCategoria : "+
               getCategoria().getNombre() + ", \nPregunta : " + pregunta +
               ", \nRespuesta : " + respuesta + ", \nNivel : " + nivel +
               ", \nFecha de creacion : " + getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +"\n}";
    }

}
