package it.ji.esercizi.u1.esercizio5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        List<Libro> libri = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("scegli cosa fare:");
            System.out.println("1) inserire un libro nella libreria");
            System.out.println("2) leggi i dati di un libro");
            System.out.println("3) sconta prezzo di un libro");
            System.out.println("0) esci");
            int scelta = in.nextInt();
            switch (scelta) {
                default: 
                    System.out.println("il numero selezionato non è presente");
                    break;
                case 0:
                    System.out.println("chiusura in corso...");
                    return;
                case 1: {
                    System.out.println("inserisci il nome del libro:");
                    in.nextLine(); // consume newline
                    String nome = in.nextLine();
                    System.out.println("inserisci il prezzo del libro:");
                    float prezzo = in.nextFloat();
                    System.out.println("inserisci il numero di scaffale del libro:");
                    int scaffale = in.nextInt();
                    System.out.println("inserisci il numero di pagine del libro:");
                    int pagine = in.nextInt();
                    System.out.println("inserisci la casa editrice del libro:");
                    in.nextLine(); // consume newline
                    String casaEditrice = in.nextLine();
                    Libro libro = new Libro(nome, prezzo, scaffale, pagine, casaEditrice);
                    libri.add(libro);  //INSERISCI UN OGGETT LIBRO IN CODA NELLA LISTA
                    System.out.println("libro inserito con successo");
                    break;
                }
                case 2: {
                    // chiedo all'utente di inserire l'indice del libro da leggere
                    System.out.println("Inserisci l'indice del libro da leggere (0 per il primo libro):");
                    int indice = in.nextInt();
                    Libro libro = libri.get(indice);  // analogo al libri[indice] se avevamo un array.
                    System.out.println(libro);
                    break;
                }
                case 3: {
                    System.out.println("Inserisci l'indice del libro da leggere (0 per il primo libro):");
                    int indice = in.nextInt();
                    Libro libro = libri.get(indice);
                    System.out.println("Il prezzo attuale del libro è: " + libro.getPrezzo() + "€");
                    System.out.println("Inserisci lo sconto da applicare (in percentuale, ad esempio 20 per il 20%):");
                    // chiedo all'utente di inserire lo sconto da applicare
                    float sconto = in.nextFloat();
                    libro.applicaSconto(sconto);
                    System.out.println("lo sconto del " + sconto + "% è stato applicato");
                    System.out.println("il prezzo è ora: " + libro.getPrezzo() + "€");
                }
            }
        }
    }
}
