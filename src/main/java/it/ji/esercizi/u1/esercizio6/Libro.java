package it.ji.esercizi.u1.esercizio6;


public class Libro {
    private String ISBN;
    private String autore;
    private String titolo;
    private int numeroPagine;

    public Libro(String autore, String isbn, String titolo, int numeroPagine) throws Exception {
        this.ISBN = isbn;
        setAutore(autore);
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) throws MissingAuthorException {
        if (autore == null || autore.isEmpty()) {
            throw new MissingAuthorException();
        }
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
