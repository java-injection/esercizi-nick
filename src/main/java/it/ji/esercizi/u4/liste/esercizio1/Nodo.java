package it.ji.esercizi.u4.liste.esercizio1;

public class Nodo {

    private String element;
    private Nodo next;

    public Nodo(String element) {
        this.element = element;
        this.next = null;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
