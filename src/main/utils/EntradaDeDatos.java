package main.utils;

import java.util.Scanner;

public class EntradaDeDatos {
    private final static Scanner scanner = new Scanner(System.in);
    private EntradaDeDatos(){}

    public static Scanner getScanner() {
        return scanner;
    }
}
