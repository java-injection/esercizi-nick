package it.ji.esercizi.u1.esercizio6;

public class MissingAuthorException extends Exception {

    public MissingAuthorException() {
        super("L'autore non può essere vuoto");
    }
}
