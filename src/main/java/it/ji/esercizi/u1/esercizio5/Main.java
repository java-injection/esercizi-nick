package it.ji.esercizi.u1.esercizio5;
import java.util.Scanner;

/*
Definisci una classe Libro contenente i seguenti attributi: nome del libro, prezzo, numero di scaffale,
 numero di pagine, casa editrice.
   Definisci inoltre i metodi inizializza(), stampa(), applicaSconto(), che hanno i seguenti compiti:
   – inizializzare i campi dati dell’oggetto classe;
   – stampare tutti i dati dell’oggetto;
   – diminuire del x% il prezzo del libro in oggetto.
 */
public class Main {

    public static void main(String[] args) {
        int x = 0;
        Scanner in = new Scanner(System.in);
        Libro libro = new Libro("", 0f, 0, 0, "");
        while (true) {
            System.out.println("scegli cosa fare:");
            System.out.println("1) inserire un libro nella libreria");
            System.out.println("2) leggi i dati di un libro");
            System.out.println("3) sconta prezzo di un libro");
            System.out.println("0) esci");
            x = in.nextInt();
            switch (x) {
                default: 
                    System.out.println("il numero selezionato non è presente");
                    break;
                case 0:
                    System.out.println("chiusura in corso...");
                    return;
                case 1:
                    //inserisci libro
                case 2: 
                    System.out.println( libro.toString());
                    break;
                case 3:
                    float sconto = 0;
                    sconto = in.nextFloat();
                    libro.applicaSconto(sconto);
                    System.out.println("lo sconto del " + sconto + "% è stato applicato");
                    System.out.println("il prezzo è ora: " + libro.getPrezzo() + "€");
            }
        }
    }
}
