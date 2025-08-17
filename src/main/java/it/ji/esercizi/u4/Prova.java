package it.ji.esercizi.u4;

import java.util.Scanner;
import java.util.Vector;

/*Scrivi un programma che generi una sequenza di numeri casuali con range (0–999), memorizzando i
numeri in tre vettori che contengono rispettivamente numeri di una cifra, di due e di tre cifre. La ge
nerazione termina quando viene estratto il numero 0.

 */
public class Prova {

    public static void main(String[] args) {
        Vector<Integer> num1Cifra = new Vector<>();
        Vector<Integer> num2Cifra = new Vector<>();
        Vector<Integer> num3Cifra = new Vector<>();

        Scanner in = new Scanner(System.in);
        int num = 0;
        System.out.println("Quanti numeri vuoi generare?");
        int quanti = in.nextInt();
        for (int i = 0; i < quanti; i++) {
            num = (int) (Math.random() * 1000);
            if (num == 0) {
                break;
            }
            if (num < 10) {
                num1Cifra.add(num);
            } else if (num < 100) {
                num2Cifra.add(num);
            } else if (num < 1000) {
                num3Cifra.add(num);
            }
        }

        //stampa tutti i contenuti dei vettori
        System.out.println("Numeri a una cifra:");
        for (int i = 0; i < num1Cifra.size(); i++) {
            System.out.println(num1Cifra.get(i));
        }
        System.out.println(" ------------------------------------------- ");
        System.out.println("Numeri a due cifre:");
        for (int i = 0; i < num2Cifra.size(); i++) {
            System.out.println(num2Cifra.get(i));
        }
//io ci sono ma mi sa che non mi senti... :/
        System.out.println("numeri a 3 cifre");
        for (int i = 0; i < num3Cifra.size(); i++) {
            System.out.println(num3Cifra.get(i));
        }


    }
}
