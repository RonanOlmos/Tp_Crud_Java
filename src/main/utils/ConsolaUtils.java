package main.utils;

public class ConsolaUtils {
    private ConsolaUtils() {} 

    public static void limpiarConsola() {
        try {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        System.out.println("No se pudo limpiar la consola");
    }
    }

    public static void pausa() {
        System.out.println("Presiona ENTER para continuar...");
        InputUtils.getScanner().nextLine();
    }
}