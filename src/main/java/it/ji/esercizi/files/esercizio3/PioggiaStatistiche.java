package it.ji.esercizi.files.esercizio3;

import java.io.File;
import java.io.IOException;

public class PioggiaStatistiche {
    
    public static void readFromFile() {
        // codice per leggere il file Pioggia.dat
        File file = new File("Pioggia.txt");
        if(!file.exists()){
            System.out.println("FILE NON TROVATO! ERRORE!!");
            return;
        }
        //stampa tutto il contenuto del file
        try {
            java.util.Scanner scanner = new java.util.Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file Pioggia.txt");
            e.printStackTrace();
        }

    }

    public static void media() {
    }

    public static void max() {
    }

    public static void periodoSiccita() {
    }
}
