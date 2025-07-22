package it.ji.esercizi.u1.esercizio7.exceptions;

public class CampoNotFoundException extends Exception {
    public CampoNotFoundException(int campoNonEsistente) {
        super("Il campo " + campoNonEsistente + " non esiste.");
    }
}
