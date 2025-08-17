package it.ji.esercizi.u4.liste.esercizio1;

import java.util.Queue;

public class Pila {

    Nodo base = null;
    Nodo top = null;

    public void push(String s) {
        if(base == null) {
            base = new Nodo(s);
            top = base;
        } else {
            Nodo nuovo = new Nodo(s);
            nuovo.setNext(top);
            top = nuovo;
        }
    }

    public String pop() {
        if(base == null) {
            return null;
        } else {
            Nodo estratto = top;
            String s = estratto.getElement();
            top = estratto.getNext();
            estratto.setNext(null);
            return s;
        }
    }


    public static void main(String[] args) {
        //test PIla
        Pila pila = new Pila();
        pila.push("a");
        pila.push("b");
        pila.push("c");
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());

    }

}
