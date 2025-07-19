package it.ji.esercizi.u1.esercizio6;

import java.util.Vector;

/*
Data la classe Libro per rappresentare oggetti Libro con il nome dell’autore, il titolo e il numero di
 pagine e con i relativi metodi d’istanza, scrivi i seguenti metodi:
 – un metodo che, ricevendo come parametro un array di oggetti Libro, calcola e restituisce una
 struttura collegata con gli stessi oggetti Libro nello stesso ordine;
 – un metodo che, ricevendo come parametro una struttura collegata di oggetti Libro, e il nome di
 un autore, verifica se nell’elenco esista almeno un libro dell’autore dato;
 – un metodo che, ricevendo come parametro un codice ISBN, elimina il libro corrispondente dal
l’elenco;
   – un metodo che ordina i libri rispetto al numero crescente di pagine
 */


// 1. Trova un elemento che .. rispetta una certa condizione
//
// 2. Verifica che tutti gli elementi .. rispettano una certa condizione

public class Main {

    public static Vector<Libro> arrayToVector(Libro[] libri){

        Vector<Libro> vector = new Vector<>();
        for (Libro a : libri) {
            vector.add(a);
        }
        return vector;
    }

    // OVERLOAD di un metodo - sovraccarico (sovraccarico il nome di un metodo)
    public static boolean isBookExisting(Libro[] libri, String autore){
        for(int i=0; i<libri.length; i++){
            if(libri[i].getAutore().equals(autore)){
                return true;
            }
        }
        return false;
    }

    public static boolean isBookExisting(Vector<Libro> libri, String autore){
        for(Libro libro : libri){
            if(libro.getAutore().equals(autore)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Libro[] libri = new Libro[3];
        libri[0] = new Libro("J.K. Rowling", "111", "Harry Potter e la pietra filosofale", 223);
        libri[1] = new Libro("George Orwell", "222", "1984", 328);
        libri[2] = new Libro("J.R.R. Tolkien", "333", "Il Signore degli Anelli", 1216);


        Vector<Libro> vectorLibri = arrayToVector(libri);

        System.out.println("============================================");

        // Esempio di utilizzo della classe Libro
        for (Libro libro : vectorLibri) {
            System.out.println("Autore: \t\t\t" + libro.getAutore());
            System.out.println("Titolo:\t\t\t\t" + libro.getTitolo());
            System.out.println("Numero di pagine: \t" + libro.getNumeroPagine());
            System.out.println("ISBN: \t\t\t\t" + libro.getISBN());
            System.out.println("--------------------------------------------");
        }
    }

    // LinkedList
    // Vector
}
