package main;

import java.util.ArrayList;

import main.crud.CardCrud;
import main.crud.CategoriaCrud;
import main.models.Card;
import main.models.Categoria;
import main.models.Flashcard;
import main.models.Nivel;
import main.utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        
        final ArrayList<Categoria> categorias = new ArrayList<>();
        final ArrayList<Card> cartas = new ArrayList<>();
        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        cartas.add(new Flashcard(0, categorias.get(0), "Que significa CPU en informatica?", "Unidad Central de Procesamiento", Nivel.FACIL));
        final CategoriaCrud categCrud = new CategoriaCrud(categorias);
        final CardCrud cardCrud = new CardCrud(cartas, categorias);

        int opcion;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1) CRUD de Cartas");
            System.out.println("2) CRUD de Categorias");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            String linea = InputUtils.getScanner().nextLine();

            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        cardCrud.mostrarOpciones();
                        op = Integer.parseInt(InputUtils.getScanner().nextLine().trim());
                        switch (op) {
                            case 1 -> cardCrud.crear();
                            case 2 -> cardCrud.listar();
                            case 3 -> cardCrud.actualizar();
                            case 4 -> cardCrud.eliminar();
                            case 0 -> System.out.println("Volviendo al menu principal...");
                            default -> System.out.println("Opcion invalida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        categCrud.mostrarOpciones();
                        op = Integer.parseInt(InputUtils.getScanner().nextLine().trim());
                        switch (op) {
                            case 1 -> categCrud.crear();
                            case 2 -> categCrud.listar();
                            case 3 -> categCrud.actualizar();
                            case 4 -> categCrud.eliminar();
                            case 0 -> System.out.println("Volviendo al menu principal...");
                            default -> System.out.println("Opcion invalida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
}
