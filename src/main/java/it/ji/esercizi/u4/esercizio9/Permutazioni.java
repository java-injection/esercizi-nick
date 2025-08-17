package it.ji.esercizi.u4.esercizio9;

import java.util.Scanner;

/*Scrivi un programma che produca N permutazioni casuali dei numeri da 1 a 10, utilizzando un array di
 supporto, riempito con numeri da 1 a 10 in modo che non ve ne siano due uguali, dal quale per dieci
 volte se ne prende uno a caso, rimuovendolo e accodandolo all’array che contiene la permutazione.*/
public class Permutazioni {

    public static void main(String[] args) {

        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Scanner sc = new Scanner(System.in);
        System.out.println("Quanti permutazioni vuoi generare?");
        int quanti = sc.nextInt();

        for (int i = 0; i < quanti; i++) {
            System.out.print("Permutazione " + (i + 1) + ": ");
            int indiceRandom = (int) (Math.random() * 10);
            System.out.println("Numero scelto a caso da rimuovere: " + array[indiceRandom]);
            int arrayTemp[] = new int[10];
            // 1 2 3 4 5 6 7 8 9 10
            //       x
            // 1 2 3 5 6 7 8 9
            int j = 0;  // scorre l'array temporaneo
            // e k scorre l'array originale
            for (int k = 0; k < 10; k++) {
                if (k != indiceRandom) {
                    arrayTemp[j] = array[k];
                    j++;
                }
            }
            //mettiamo in coda l'elemento scelto a caso
            arrayTemp[j] = array[indiceRandom];
            //stampiamo la permutazione
            for (int k = 0; k < 10; k++) {
                System.out.print(arrayTemp[k] + " ");
            }
            System.out.println();
        }

    }
}
