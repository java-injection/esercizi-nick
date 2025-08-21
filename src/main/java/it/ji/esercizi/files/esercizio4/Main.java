package it.ji.esercizi.files.esercizio4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

// Scrivi un programma che realizzi due funzioni:
// – la prima deve creare un file in modalità formattata e inserire nel file valori interi acquisiti da
//   tastiera, fino a un massimo di 30;
// – la seconda deve leggere i dati dal file prodotto dalla esecuzione della prima funzione e verificare
//   che nel file siano presenti valori ripetuti e, in tal caso, deve sostituirli con numeri non presenti.
public class Main {

    private static final String FILE_NUMERI = "numeri.txt"; // file formattato (testo)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un'operazione e premi invio:");
            System.out.println("1) Inserisci fino a 30 numeri e salva su file");
            System.out.println("2) Leggi e stampa il file");
            System.out.println("3) Correggi duplicati sostituendoli con numeri non presenti");
            System.out.println("0) Esci");
            int scelta = in.nextInt();

            switch (scelta) {
                case 0:
                    System.out.println("Chiusura in corso...");
                    in.close();
                    return;
                case 1:
                    scriviNumeri(in);
                    break;
                case 2:
                    leggiNumeri();
                    break;
                case 3:
                    correggiDuplicati();
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    // Funzione 1: chiedi quanti numeri (max 30), poi leggi i numeri e salva formattati su file
    private static void scriviNumeri(Scanner in) {
        System.out.println("Quanti numeri vuoi inserire? (max 30)");
        int n = in.nextInt();
        if(n > 30) {
            System.out.println("Non puoi inserire più di 30 numeri.");
            return;
        }

        Vector<Integer> a = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci l'intero n." + (i + 1) + ":");
            int val = in.nextInt();
            a.add(val);
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NUMERI)));
            for (int i = 0; i < n; i++) {
                out.println(a.elementAt(i));
            }
            out.flush();
            System.out.println("Salvataggio completato su '" + FILE_NUMERI + "'.");
        } catch (IOException e) {
            System.out.println("Errore in scrittura file: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    // Stampa i numeri presenti nel file (uno per riga)
    private static void leggiNumeri() {
        File f = new File(FILE_NUMERI);
        if (!f.exists()) {
            System.out.println("Il file '" + FILE_NUMERI + "' non esiste.");
            return;
        }
        Scanner sc = null;
        try {
            sc = new Scanner(f);
            System.out.println("Contenuto del file:");
            while (sc.hasNextInt()) {
                int v = sc.nextInt();
                System.out.println(v);
            }
        } catch (Exception e) {
            System.out.println("Errore in lettura: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    // Funzione 2: legge i numeri, sostituisce i duplicati con valori non presenti e risalva il file
    private static void correggiDuplicati() {
        File f = new File(FILE_NUMERI);
        if (!f.exists()) {
            System.out.println("Il file '" + FILE_NUMERI + "' non esiste.");
            return;
        }

        // leggi i numeri dal file
        Vector<Integer> vettoreSupport = new Vector<Integer>();

        Scanner sc = null;
        try {
            sc = new Scanner(f);
            while (sc.hasNextInt()) {
                vettoreSupport.add(sc.nextInt());
            }
        } catch (Exception e) {
            System.out.println("Errore in lettura: " + e.getMessage());
            return;
        } finally {
            if (sc != null) sc.close();
        }

        if (vettoreSupport.size() == 0) {
            System.out.println("Il file è vuoto.");
            return;
        }
        // -- fine lettura numeri dal file --

        // sostituisce i duplicati con valori non presenti
        boolean cambiato = false;
        for (int i = 0; i < vettoreSupport.size(); i++) {
            // controlla se il valore a[i] è già apparso prima
            int val = vettoreSupport.elementAt(i);
            boolean duplicato = false;
            for (int j = 0; j < i; j++) {
                if (vettoreSupport.elementAt(j) == val) {
                    duplicato = true;
                    break;
                }
            }
            if (duplicato) {
                int numeroDaSostituire = 0; // prova da 0 in su
                while (contains(vettoreSupport, numeroDaSostituire)) {
                    numeroDaSostituire++;
                }
                vettoreSupport.setElementAt(numeroDaSostituire, i); // sostituzione con numero non presente
                cambiato = true;
            }
        }

        if (!cambiato) {
            System.out.println("Nessun duplicato trovato. Nessuna modifica effettuata.");
            return;
        }

        // riscrivi il file con i valori aggiornati
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NUMERI)));
            for (int i = 0; i < vettoreSupport.size(); i++) {
                out.println(vettoreSupport.elementAt(i));
            }
            out.flush();
            System.out.println("Duplicati corretti e file aggiornato.");
        } catch (IOException e) {
            System.out.println("Errore in scrittura file: " + e.getMessage());
        } finally {
            if (out != null) out.close();
        }
    }

    private static boolean contains(Vector<Integer> a, int value) {
        for (int i = 0; i < a.size(); i++) {
            if (a.elementAt(i) == value) return true;
        }
        return false;
    }
}
