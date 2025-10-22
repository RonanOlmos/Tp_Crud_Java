package main.utils;

import java.util.Scanner;

public class InputUtils {
    private final static Scanner scanner = new Scanner(System.in);
    private InputUtils(){}

    public static Scanner getScanner() {
        return scanner;
    }
}
