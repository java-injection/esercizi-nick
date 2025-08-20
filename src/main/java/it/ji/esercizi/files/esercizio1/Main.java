package it.ji.esercizi.files.esercizio1;

import java.io.*;
import java.util.Scanner;

public class Main {

//    Scrivi un programma che legga un file di testo matrice.dat contenente 3 righe, con 3 interi separati
//    da uno spazio per ogni riga. Il programma deve leggere il file, creare una matrice 3 × 3 contenente
//    i dati presenti in matrice.date stamparne la sua trasposta.
    public static void main(String[] args) {

        File file = new File("matrice.dat");
        
        // Prima creiamo un file di esempio se non esiste
        if (!file.exists()) {
            System.out.println("FILE NON TROVATO! ERRORE!!");
            System.exit(1);
        }else{
            System.out.println("FILE TROVATO");
        }

        // Leggiamo la matrice dal file di testo
        int[][] matrice = new int[3][3];
        
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Matrice originale:");
            for (int i = 0; i < 3; i++) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] numeri = line.split(" ");
                    if (numeri.length >= 3) {
                        for (int j = 0; j < 3; j++) {
                            matrice[i][j] = Integer.parseInt(numeri[j]);
                            System.out.print(matrice[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }

            int [][] matriceTrasposta = new int[3][3];
            // Stampiamo la trasposta
            System.out.println("\nMatrice trasposta:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matriceTrasposta[i][j] = matrice[j][i];
                    System.out.print(matriceTrasposta[i][j] + " ");
                }
                System.out.println();
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Errore nel formato dei numeri: " + e.getMessage());
        }
    }
}