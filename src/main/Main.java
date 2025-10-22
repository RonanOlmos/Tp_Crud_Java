package main;

import java.util.ArrayList;

import main.crud.CategoriaCrud;
import main.models.Categoria;
import main.utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        
        final ArrayList<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        final CategoriaCrud categCrud = new CategoriaCrud(categorias);

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            //System.out.println("1) CRUD de Productos");
            System.out.println("2) CRUD de Categorías");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String linea = InputUtils.getScanner().nextLine();

            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
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
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
