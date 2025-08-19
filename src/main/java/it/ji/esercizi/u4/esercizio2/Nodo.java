package it.ji.esercizi.u4.esercizio2;

public class Nodo {

    private char[] element;
    private Nodo next;

    public Nodo(char[] element) {
        this.element = element;
        this.next = null;
    }

    public char[] getElement() {
        return element;
    }

    public void setElement(char[] element) {
        this.element = element;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
