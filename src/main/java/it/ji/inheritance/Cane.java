package it.ji.inheritance;

public abstract class Cane extends Animale{

    public Cane(String nome, String razza) {
        super(nome, 4, razza);
    }

    public void verso() {
        System.out.println("Bau Bau");
    }
}
