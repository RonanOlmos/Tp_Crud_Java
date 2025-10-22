package main.models;

public class Flashcard extends Card{
    private String pregunta;
    private String respuesta;
    private Nivel nivel;

    public Flashcard(int id, Categoria categoria,
                     String pregunta, String respuesta, Nivel nivel) {
        super(id, categoria);
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
        return "Flashcard[Id : " + getId() +", "+
               getCategoria().toString() + ", Pregunta : " + pregunta +
               ", Respuesta : " + respuesta + ", Nivel : " + nivel +
               ", Fecha de creacion : " + getFechaCreacion() +"]";
    }

}
