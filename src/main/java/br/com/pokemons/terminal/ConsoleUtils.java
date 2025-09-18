package br.com.pokemons.terminal;

import br.com.pokemons.arts.AsciiArt;

public class ConsoleUtils {

    // Códigos de Cores ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void limparTela() {

        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void imprimirTitulo() {

        limparTela();
        System.out.println(ANSI_YELLOW + AsciiArt.mimikyu + ANSI_RESET);
        System.out.println(ANSI_BLUE + "======================================" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "             POKEWEAK                " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "======================================" + ANSI_RESET);
    }
}