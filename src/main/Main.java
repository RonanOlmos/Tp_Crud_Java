package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.crud.CategoriaCrud;
import main.models.Categoria;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        final CategoriaCrud crudCat = new CategoriaCrud(categorias);

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            //System.out.println("1) CRUD de Productos");
            System.out.println("2) CRUD de Categorías");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String linea = scanner.nextLine();
            // que es manejo de excepciones?
            //   - Es una técnica para manejar errores en tiempo de ejecución.
            //   - Permite que el programa continúe ejecutándose en lugar de fallar abruptamente.
            //   - Mejora la experiencia de usuario al proporcionar mensajes claros de error.
            // que pasa si no manejamos la excepción?
            //   - El programa podría fallar y cerrarse inesperadamente.
            //   - El usuario no entendería qué salió mal.
            //   - Podríamos perder datos o estado importante del programa.
            // que es NumberFormatException?
            //   - Es una excepción que ocurre cuando se intenta convertir una cadena a un número
            //     y la cadena no tiene un formato válido.
            //   - Es una subclase de IllegalArgumentException.
            //   - Es común al leer entradas del usuario que no son números.
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = Integer.parseInt(scanner.nextLine().trim());;
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
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
