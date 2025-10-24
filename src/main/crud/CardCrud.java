package main.crud;

import java.util.ArrayList;

import main.models.Card;
import main.models.Categoria;
import main.models.Flashcard;
import main.models.Nivel;
import main.models.Triviacard;
import main.utils.ConsolaUtils;
import main.utils.InputUtils;

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
        if (op == 1) { //Creacion de Flashcard

            if (categorias.isEmpty()) {
                ConsolaUtils.limpiarConsola();
                System.out.println("No tienes categorias creadas.\nCrea una nueva categoria para avanzar...");
                ConsolaUtils.pausa();
                return;
            }
            
            String pregunta = leerTexto("Ingrese la pregunta de la Flashcard: ");

            String respuesta = leerTexto("Ingrese la respuesta de la Flashcard: ");

            System.out.println("Seleccione el nivel de dificultad: ");
            System.out.println("1. FACIL");
            System.out.println("2. MEDIO");
            System.out.println("3. DIFICIL");
            Nivel nivel;
            int opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> nivel = Nivel.FACIL;
                case 2 -> nivel = Nivel.MEDIO;
                case 3 -> nivel = Nivel.DIFICIL;
                default -> {
                    System.out.println("Opcion invalida. Se asigno MEDIO por defecto.");
                    nivel = Nivel.MEDIO;
                }
            }
            ConsolaUtils.limpiarConsola();

            System.out.println("Selecciona una de las categorias disponibles:");
            categorias.forEach(System.out::println);
            int idCat = leerEntero("Elige el id de categoria: ");
            Categoria seleccionada = buscarCategoriaPorId(categorias, idCat);
            if (seleccionada != null) {
                cartas.add(new Flashcard(seleccionada,pregunta,respuesta,nivel));
                ConsolaUtils.limpiarConsola();
                System.out.println("Flashcard creada exitosamente!");
            } else {
                System.out.println("Error!!! No existe la categoria, la Flashcard no fue creada!");
            }
            
            
        }else if (op == 2) {// Creacion de Triviacard
            if (categorias.isEmpty()) {
                ConsolaUtils.limpiarConsola();
                System.out.println("No tienes categorias creadas.");
                ConsolaUtils.pausa();
                return;
            }

            ConsolaUtils.limpiarConsola();
            String pregunta = leerTexto("Ingrese el nombre de la pregunta: ");

            ArrayList<String> opciones = new ArrayList<>();
            for (int i = 0; i <= 2; i++) {
                String opcionTexto = leerTexto("Ingrese la opcion " + i + ": ");
                opciones.add(opcionTexto);
            }
            int indice;
            do {
                indice = leerEntero("Ingrese el indice de la respuesta correcta: ");
            } while (indice < 0 || indice >= opciones.size());
            
            ConsolaUtils.limpiarConsola();
            System.out.println("Selecciona una de las categorias disponibles:");
            categorias.forEach(System.out::println);
            int idCat = leerEntero("Elige el id de categoria: ");
            Categoria seleccionada = buscarCategoriaPorId(categorias, idCat);
            if (seleccionada != null) {
                cartas.add(new Triviacard(seleccionada,pregunta,opciones,indice));
                ConsolaUtils.limpiarConsola();
                System.out.println("Triviacard creada exitosamente!");
            } else {
                System.out.println("Error!!! No existe la categoria, la Flashcard no fue creada!");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void listar() {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas actualmente...");
        } else {
            cartas.forEach(System.out::println);
        }
    }

    @Override
    public void actualizar() {

        listar();
        int idCarta = leerEntero("Ingrese el id de la carta a modificar: ");
        Card carta = cartas.stream()
                            .filter(c -> c.getId() == idCarta)
                            .findFirst()
                            .orElse(null);
        if(carta == null){
            ConsolaUtils.limpiarConsola();
            System.out.println("No existe una carta con el id: " + idCarta);
            return;
        }

        if(carta instanceof Flashcard flashcard){
            modificarFlashcard(flashcard);
        } else if(carta instanceof Triviacard triviacard){
            modificarTriviacard(triviacard);
        }
        
    }

    @Override
    public void eliminar() {
        
    }

    private Categoria buscarCategoriaPorId(ArrayList<Categoria> categorias, int idCat){
        Categoria seleccionada = categorias.stream()
                                           .filter(c -> c.getId() == idCat)
                                           .findFirst()
                                           .orElse(null);
        return seleccionada;
    }

    private void modificarFlashcard(Flashcard flashcard){
        int opcion;
        do {
            ConsolaUtils.limpiarConsola();
            System.out.println(flashcard);
            System.out.println("Selecciona que quieres cambiar de la flashcard:");
            System.out.println("1) Modificar pregunta");
            System.out.println("2) Modificar respuesta");
            System.out.println("3) Modificar nivel");
            System.out.println("0) Salir");
            String linea = InputUtils.getScanner().nextLine();
            
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    String nuevaPregunta= leerTexto("Ingrese una nueva pregunta: ");
                    flashcard.setPregunta(nuevaPregunta);
                }

                case 2 -> {
                    String nuevaRespuesta = leerTexto("Ingrese una nueva respuesta: ");
                    flashcard.setRespuesta(nuevaRespuesta);
                }

                case 3 -> {
                    System.out.println("Selecciona un nuevo nivel:");
                    System.out.println("1) Facil");
                    System.out.println("2) Medio");
                    System.out.println("3) Dificil");
                    int n = leerEntero("Opcion: ");
                    switch (n) {
                        case 1 -> flashcard.setNivel(Nivel.FACIL);
                        case 2 -> flashcard.setNivel(Nivel.MEDIO);
                        case 3 -> flashcard.setNivel(Nivel.DIFICIL);
                        default -> System.out.println("Nivel inválido. No se cambió.");
                    }
                    System.out.println("Nivel actualizado.");
                    
                }
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void modificarTriviacard(Triviacard triviacard){
        int opcion;
        do {
            ConsolaUtils.limpiarConsola();
            System.out.println(triviacard);
            System.out.println("Selecciona que quieres cambiar de la triviacard:");
            System.out.println("1) Modificar pregunta");
            System.out.println("2) Modificar respuestas");
            System.out.println("3) Modificar respuesta correcta");
            System.out.println("0) Salir");
            String linea = InputUtils.getScanner().nextLine();
            
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    String nuevaPregunta= leerTexto("Ingrese una nueva pregunta: ");
                    triviacard.setPregunta(nuevaPregunta);
                }

                case 2 -> {
                    //String nuevaRespuesta = leerTexto("Ingrese una nueva respuesta: ");
                    //flashcard.setRespuesta(nuevaRespuesta);
                }

                case 3 -> {
                    
                    
                }
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    };
}