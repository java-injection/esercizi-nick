package it.ji.esercizi.u4.liste.esercizio1;

import java.util.Queue;

public class Pila {

    private Nodo top = null;


    public void push(String s) {
        if(isEmpty()){
            top = new Nodo(s);
        }else{
            Nodo nuovoNodo = new Nodo(s);
            nuovoNodo.setNext(top);
            top = nuovoNodo;
        }
    }

    public String pop() {
        if(isEmpty()) {
            return null;
        }else{
            Nodo n = top;
            top = top.getNext();
            return n.getElement();
        }

    }

    public boolean isEmpty() {
        if(top == null) {
            return true;
        }else {
            return false;
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
