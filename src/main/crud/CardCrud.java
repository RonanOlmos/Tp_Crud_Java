package main.crud;

import java.util.ArrayList;

import main.models.Card;
import main.models.Categoria;
import main.models.Flashcard;
import main.models.Nivel;
import main.utils.ConsolaUtils;

public class CardCrud extends ConsolaCrud<Card>{
    private final ArrayList<Categoria> categorias;
    private final ArrayList<Card> cartas;

    public CardCrud(ArrayList<Card> cartas, ArrayList<Categoria> categorias){
        this.cartas = cartas;
        this.categorias = categorias;
    }
    @Override
    public void crear() {
        ConsolaUtils.limpiarConsola();
        System.out.println("Que tipo de carta quieres crear?");
        System.out.println("1) Crear Flashcard");
        System.out.println("2) Crear Triviacard");
        int op = leerEntero("Elege una opcion: ");
        ConsolaUtils.limpiarConsola();
        if (op == 1) {
            if (categorias.isEmpty()) {
                ConsolaUtils.limpiarConsola();
                System.out.println("No tienes categorias creadas.");
                ConsolaUtils.pausa();
                return;
            }
            String pregunta = leerTexto("Ingrese la pregunta del Flashcard: ");
            String respuesta = leerTexto("Ingrese la respuesta del Flashcard: ");
            System.out.println("Seleccione el nivel de dificultad:");
            System.out.println("1. FACIL");
            System.out.println("2. MEDIO");
            System.out.println("3. DIFICIL");
            Nivel nivel;
            int opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1: nivel = Nivel.FACIL;
                case 2: nivel = Nivel.MEDIO;
                case 3: nivel = Nivel.DIFICIL;
                default:
                    System.out.println("Opcion invalida. Se asigno MEDIO por defecto.");
                    nivel = Nivel.MEDIO;
            }
            ConsolaUtils.limpiarConsola();
            System.out.println("Categorias disponibles:");
            for (Categoria c : categorias) {
                System.out.print(c);
            }
            int idCat = leerEntero("Elegí id de categoría: ");
            Categoria seleccionada = null;
            for (Categoria c : categorias) {
                if (c.getId() == idCat) { seleccionada = c; break; }
            }
            if (seleccionada != null) {
                cartas.add(new Flashcard(seleccionada,pregunta,respuesta,nivel));
                System.out.println("Flashcard creada.");
            } else {
                System.out.println("No existe la categoria.");
            }
            
            
        } /*else if (op == 2) {
            String nombre = leerTexto("Nombre: ");
            double precio = leerDouble("Precio: ");
            int duracion = leerEntero("Duración (horas): ");
            productos.add(new Servicio(nombre, precio, duracion));
            System.out.println("Servicio creado.");
        } else {
            System.out.println("Opción inválida.");
        }*/
    }

    @Override
    public void listar() {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas actualmente...");
        } else {
            for (Card c : cartas) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        
    }

    @Override
    public void eliminar() {
        
    }

}
