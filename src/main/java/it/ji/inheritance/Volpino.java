package it.ji.inheritance;

public class Volpino extends Cane {
    public Volpino(String nome) {
        super(nome, "Volpino");
    }

    @Override
    public void verso() {
        System.out.println("VOLP VOLP");
    }
}
