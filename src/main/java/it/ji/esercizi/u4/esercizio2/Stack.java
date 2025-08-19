package it.ji.esercizi.u4.esercizio2;

public class Stack {

    Nodo base = null;
    Nodo top = null;

    public boolean isEmpty() {
        return base == null;
    }

    public void push(char [] s) {
        if(base == null) {
            base = new Nodo(s);
            top = base;
        } else {
            Nodo nuovo = new Nodo(s);
            nuovo.setNext(top);
            top = nuovo;
        }
    }

    public char [] pop() {
        if(base == null) {
            return null;
        } else {
            Nodo estratto = top;
            char [] riga = estratto.getElement();
            top = estratto.getNext();
            estratto.setNext(null);
            return riga;
        }
    }


}
