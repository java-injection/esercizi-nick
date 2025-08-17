package it.ji.esercizi.u4.liste.esercizio1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Esercizio1 {
//    Leggi una stringa e, utilizzando una struttura di tipo pila, riconosci se è palindroma.
//            (Una parola o una frase è palindroma quando può essere letta in entrambi i sensi, come per esempio
//    ossesso, anna, alla, itopinonavevanonipoti ecc.).
    public static void main(String[] args) {

         //
         //    A   A
         //    N   T
         //    N   N
        //     A   A

        // A N N A
        // A N T A

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una parola: ");
        String parola = scanner.nextLine();
        scanner.close();

        Pila pila = new Pila();
        //scorri la parola e aggiungi alla pila
        for (int i = 0; i < parola.length(); i++) {
            pila.push(parola.charAt(i) + "");
        }

        //estrai dalla cima della pila con pop e la confronta con la parola inserita
        for (int i = 0; i < parola.length(); i++) {
            if (!pila.pop().equals(parola.charAt(i) + "")) {
                System.out.println("La parola NON è palindroma");
                return;
            }
        }
        System.out.println("La parola è palindroma");


    }
}
