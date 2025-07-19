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

    //un metodo che, ricevendo come parametro un codice ISBN, elimina il libro corrispondente dal
    //l’elenco;
    public static void removeBookByISBN(Vector<Libro> libri, String isbn) {
        for (int i = 0; i < libri.size(); i++) {
            if (libri.get(i).getISBN().equals(isbn)) {
                libri.remove(i);
                return; // Esce dal metodo dopo aver rimosso il libro
            }
        }

    }

    //remove by passing a Book object
    public static void removeBookByObject(Vector<Libro> libri, Libro libro) {
        libri.remove(libro);
    }

    public static void sortBookByPages(Vector<Libro> libri) {
        int n = libri.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (libri.get(j).getNumeroPagine() > libri.get(j + 1).getNumeroPagine()) {
                    // Scambio degli elementi
                    Libro temp = libri.get(j);
                    libri.set(j, libri.get(j + 1));
                    libri.set(j + 1, temp);
                }
            }
        }
    }

    public static int raddoppia(int x){
        x = x * 2;
        return x;
    }

    public static void cambiaNomeLibro(Libro libro){
        libro.setTitolo("Nuovo Titolo");
    }

    public static void main(String[] args) throws Exception {
        Libro[] libri = new Libro[3];
        libri[0] = new Libro("J.K. Rowling", "111", "Harry Potter e la pietra filosofale", 560);
        libri[1] = new Libro("George Orwell", "222", "1984", 1255);
        libri[2] = new Libro("J.R.R. Tolkien", "333", "Il Signore degli Anelli", 60);


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

//        // Proviamo a cancellare il libro con ISBN "222"
//        System.out.println("Rimozione del libro con ISBN '222'...");
//        removeBookByISBN(vectorLibri, "222");
//        System.out.println("Libri dopo la rimozione:");


        // PROVA A RIMUOVERE UN OGGETTO LIBRO
//        System.out.println(" ============================================");
//        // Proviamo a rimuovere un libro specifico
//        System.out.println("Rimozione del libro '1984' di George Orwell...");
//        Libro libroDaRimuovere = new Libro("George Orwell", "222", "1984", 328);
//        removeBookByObject(vectorLibri, libroDaRimuovere);
//        System.out.println("Elenco dei libri dopo la rimozione:");
//        for (Libro libro : vectorLibri) {
//            System.out.println("Autore: \t\t\t" + libro.getAutore());
//            System.out.println("Titolo:\t\t\t\t" + libro.getTitolo());
//            System.out.println("Numero di pagine: \t" + libro.getNumeroPagine());
//            System.out.println("ISBN: \t\t\t\t" + libro.getISBN());
//            System.out.println("--------------------------------------------");
//        }
//
//        // prova a darmi l'indice del libro passando tutto l'oggetto
//        System.out.println(" ============================================");
//        int indexToRemove = vectorLibri.indexOf(libroDaRimuovere);
//        System.out.println("Indice del libro da rimuovere: " + indexToRemove);

        //ordiniamo i libri per numero di pagine
        System.out.println(" ============================================");
        System.out.println("Ordinamento dei libri per numero di pagine...");
        sortBookByPages(vectorLibri);

        for (Libro libro : vectorLibri) {
            System.out.println("Autore: \t\t\t" + libro.getAutore());
            System.out.println("Titolo:\t\t\t\t" + libro.getTitolo());
            System.out.println("Numero di pagine: \t" + libro.getNumeroPagine());
            System.out.println("ISBN: \t\t\t\t" + libro.getISBN());
            System.out.println("--------------------------------------------");
        }


        cambiaNomeLibro(vectorLibri.get(0));
        System.out.println("Dopo aver cambiato il titolo del primo libro:");

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
